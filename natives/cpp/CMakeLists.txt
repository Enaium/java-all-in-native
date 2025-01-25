cmake_minimum_required(VERSION 3.0)
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_WINDOWS_EXPORT_ALL_SYMBOLS ON)
project("lib")
add_library(
        ${PROJECT_NAME}
        SHARED
        src/lib.cpp
)
target_link_libraries(${PROJECT_NAME})