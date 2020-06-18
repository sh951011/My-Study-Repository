#pragma once
#include <stdio.h>
#include <stdlib.h>

#define MAX_STACK_SIZE 200	
#define Element	char 
#define printElem(e) printf("%c", e)
#define TRUE 1
#define FALSE 0		
#define ERROR -1	//	������ �� �Ǵ� ����� ������ �� ERROR return

typedef int boolean;	//	TRUE, FALSE�� ��Ÿ���� ���� �� �Լ��� ǥ���ϱ� ���� Ÿ�� ������
typedef struct ArrayStack {
	Element	data[MAX_STACK_SIZE];
	int		top;
} Stack;

extern void error(char* str );
extern void initStack( Stack* s );
extern boolean isEmpty( Stack* s );
extern boolean isFull( Stack* s );
extern void push ( Stack* s, Element e );
extern Element pop ( Stack* s );
extern Element peek ( Stack* s );
extern int size( Stack* s );
extern void display ( Stack* s, char* msg );

// ��ȣ ���� 13�� -> ���� ���� ������ ����� �����ϳ� Ȯ���ϱ� ���� Test

