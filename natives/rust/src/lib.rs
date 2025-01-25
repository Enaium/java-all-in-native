use std::ffi::{c_char, CString};

#[no_mangle]
extern "C" fn greeting(greeting: *const c_char) -> *mut c_char {
    let c_str = unsafe {
        assert!(!greeting.is_null());
        CString::from_raw(greeting as *mut _)
    };
    CString::new(format!("{} {}!", c_str.to_str().unwrap(), "Rust"))
        .unwrap()
        .into_raw()
}
