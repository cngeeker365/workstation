#include <stdio.h>
#include <jni.h>
#include "Hello.h"

EXPORT void JNICALL Java_Hello_hi (JNIEnv *env, jobject o){
    printf("Hello, i come from c programming...\n");
}