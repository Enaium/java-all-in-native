mkdir build;go build -ldflags "-s -w" -buildmode=c-shared -o build/lib.dll lib.go
# go build -ldflags "-s -w" -buildmode=c-shared -o build/lib.so lib.go