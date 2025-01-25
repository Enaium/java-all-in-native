package main

import "C"

//export greeting
func greeting(greeting *C.char) *C.char {
	return C.CString(C.GoString(greeting) + " Go!")
}

func main() {

}
