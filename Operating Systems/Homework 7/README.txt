Line 41: Left as pthread_create(...args)
If we leave it as is, then one thread may access and update the value, however, 
the other thread still have counter = 0, therefore, when it accesses counter, it
will overwrite and cause it to be 1.

Solution: Wait for thread to join so that way only one thread can perform calculation
in a critical section. Line numbers 56 and 57 (includes comment).