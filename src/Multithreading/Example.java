package Multithreading;

/**
 * Created by nikhilagrawal on 20/01/17.
 */
class Example {
    int value = 0;

    // similar to :4 case in the c++ example
    static void accept_reference(Example e) { // :1
        e.value++; // will change the referenced object
        e = null; // will only change the parameter
    }

    // similar to the :2 case in the c++ example
    static void accept_primitive(int v) { // :2
        v++; // will only change the parameter
    }

    public static void main(String... args) {
        int value = 0;
        Example ref = new Example(); // reference

        // note what we pass is the reference, not the object. we can't
        // pass objects. The reference is copied (pass-by-value).
        accept_reference(ref); // :1
        assert ref != null && ref.value == 1;

        // the primitive int variable is copied
        accept_primitive(value); // :2
        assert value == 0;
    }
}