#include "./lib.h"
#include <format>

const char *greeting(const char *greeting) {
    auto language = "C++";
    return std::format("{0} {1}!", greeting, language).c_str();
}
