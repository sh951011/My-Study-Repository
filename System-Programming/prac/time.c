#include <stdio.h>
#include <time.h>

void main(){
	time_t t;
	for(;;)
		printf("current time: %ld\n",(long)time(&t));
//	printf("the same value: %ld\n",(long)t);
}
