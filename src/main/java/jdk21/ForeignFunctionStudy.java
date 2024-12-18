package jdk21;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.ValueLayout;

public class ForeignFunctionStudy {

    public static void main(String[] args) throws Throwable {

        // Arena：用来管理内存分配的范围，Arena.ofConfined() 表示创建一个线程封闭的内存区域。它会自动释放分配的内存（类似 try-with-resources 中的资源管理）。
        try (Arena arena = Arena.ofConfined()) {

            // Linker：Linker.nativeLinker() 是用于连接和调用本地代码的对象。
            final var linker = Linker.nativeLinker();

            // symbolLookup：通过 linker.defaultLookup() 获取默认的符号查找器，用来查找本地库中的函数（例如 strlen）。
            final var symbolLookup = linker.defaultLookup();

            // MemorySegment：指向本地内存区域的引用，描述函数的地址。
            final var memorySegment = symbolLookup.find("strlen").orElseThrow();

            // FunctionDescriptor：描述调用函数的参数和返回类型。
            final var functionDescriptor = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);

            // MethodHandle：表示一个可以调用本地函数的句柄。
            final var methodHandle = linker.downcallHandle(memorySegment, functionDescriptor);

            // 分配本地内存并存储字符串
            final var segmentAllocator  = arena.allocateUtf8String("Hello World");

            // 调用 strlen 函数
            final var result = (long)methodHandle.invokeExact(segmentAllocator);

            System.out.println(result);
        }
    }

}
