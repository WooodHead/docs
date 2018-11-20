# Java Security Overview

* Insecure Pseudo-Random Number Generator Used
       
First, java.util.Random is a linear congruential pseudorandom number generator Second, the linear congruential pseudorandom  can be predicted so, we should change java.util.Random into java.security.SecureRandom according to the report