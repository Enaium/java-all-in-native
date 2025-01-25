using System.Runtime.InteropServices;

namespace csharp;

public class Lib
{
    [UnmanagedCallersOnly(EntryPoint = "greeting")]
    public static IntPtr Greeting(IntPtr greeting)
    {
        return Marshal.StringToHGlobalAnsi($"{Marshal.PtrToStringAnsi(greeting)} C#!");
    }
}
