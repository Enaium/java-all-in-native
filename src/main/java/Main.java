/**
 * @author Enaium
 */
void main() throws Throwable {
    try (final var arena = Arena.ofConfined()) {
        System.loadLibrary("lib");
        final var linker = Linker.nativeLinker();
        final var lib = SymbolLookup.loaderLookup();
        final var greeting = (MemorySegment) linker.downcallHandle(
                lib.findOrThrow("greeting"),
                FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.ADDRESS)
        ).invoke(arena.allocateFrom("Hello"));
        final String string = greeting.reinterpret(Integer.MAX_VALUE).getString(0);
        System.out.println(string);
    }
}