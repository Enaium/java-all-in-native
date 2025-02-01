const std = @import("std");

pub export fn greeting(greet: [*c]const u8) [*c]const u8 {
    const lang = " Zig!";
    const allocator = std.heap.c_allocator;
    const g: [:0]const u8 = std.mem.span(greet);
    const len = g.len + lang.len;
    const result = allocator.alloc(u8, len) catch unreachable;

    std.mem.copyForwards(u8, result[0..g.len], g);
    std.mem.copyForwards(u8, result[g.len..len], lang);

    return result.ptr;
}
