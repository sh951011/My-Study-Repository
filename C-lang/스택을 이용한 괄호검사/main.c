/*
*				KwangWoon University ������Ű��а�
*				2014707073 ���ȯ
*				�ڷᱸ�� Hw1 : c��� Stack�� �̿��� ��ȣ �˻�
*/

#define _CRT_SECURE_NO_WARNINGS		// fopen() �Լ� ERROR ���Ÿ� ���� define
#include "ArrayStack.h"

void parentheses_open(Stack *stack,Stack *check_stack, char open);											/*	 '(','{','[' case�� ����Ǵ� �Լ�	 */
void parentheses_close(Stack *stack, char open, char close);							/*	')','}',']' case�� ����Ǵ� �Լ�	 */
void asterisk_case(Stack *stack, boolean *bMLineCmt);									/*		 '*' case�� ����Ǵ� �Լ�		 */
void slash_case(Stack *stack, boolean *bLineCmt, boolean *bMLineCmt,Element memory);	/*		 '/' case�� ����Ǵ� �Լ�	     */
int bracketChecker(char* filename);													/*	�Ѱܹ��� ���ϸ��� ���� ��ȣ�˻� �����Լ�	 */		

/* main �Լ� */
void main()
{
	//	���� �ڵ�� Ȥ�� �� ���ư��� ���ܻ�Ȳ�� �ִ����� üũ (( {{
	/* * {{[[   */
	// '''
	// "'"
	// ({[/
	/* ([/{[*/
	/*	*i/*i(({/[]]}/*oi*k/
	*****)(/*
	'''	{{{
	"	(({{]]]))/	//[/[/][/() {}
	*/
	printf("\n=============== ������ �ִ� c�ڵ��� TEST ===============\n\n");
	bracketChecker("ArrayStack.h");
	bracketChecker("ArrayStack.c");
	bracketChecker("3000LineTest.c");
	bracketChecker("main.c");
	bracketChecker("automobile.h");
	bracketChecker("InverseMatrix.c");
	bracketChecker("MyLinkedList.h");
	bracketChecker("stack.h");
	bracketChecker("queue.h");
	bracketChecker("tree.h");
	printf("\n\n=============== �Ϻη� �������� TEST ===============\n\n");
	bracketChecker("test.txt");
}

/*	�Ѱܹ��� ���ϸ��� ���� ��ȣ�˻� �����Լ�	 */
int bracketChecker(char* filename) {
	int nLine = 1, nChar = 0;	//	�˻��� �ڵ��� line���� char���� ���� ������ ���.
	int parenthesesCount = 0;	//	( { [ �� ����̳�
	//	bSingle -> '	bDouble -> "	bLineCmt -> //	bMLineCmt -> /*~*/
	boolean bSingle, bDouble, bLineCmt, bMLineCmt;	 
	char	ch;
	Stack	stack,check_stack;	//	stack�� ( { [ �� ���� �����̰�, check_stack�� / * �� ����
								//	�ּ��̳� ����ǥ�� ���� ���ܻ�Ȳ�� üũ�ϱ� ���� ����
	FILE *fp = fopen(filename, "r");
	Element memory = NULL;	//	������ �Դ� ���� ����ϱ� ���� ����

	if (fp == NULL)
		error("Error: The file does not exist.\n");

	initStack(&stack);
	initStack(&check_stack);
	bSingle = bDouble = bLineCmt = bMLineCmt = FALSE;

	while ((ch = getc(fp)) != EOF) {
		nChar++;
		switch (ch) {
		case '"':
			if (!bSingle && !bMLineCmt && !bLineCmt) {
				if (bDouble) {
					bDouble = FALSE;		//	"�� �տ� �������� ���� �������Ƿ� bDouble ���� //// test�� -> ( (((((
				}
				else bDouble = TRUE;
			}
			break;

		case 39:	// '�� �ƽ�Ű�ڵ�.  ''' ���� �ߴ��� ������ ���� ASCII CODE�� ��
			if (!bDouble && !bMLineCmt && !bLineCmt) {
				if (bSingle) {
					bSingle = FALSE;
				}
				else bSingle = TRUE;
			}
			break;

		case '/':
			if (!bLineCmt && !bSingle && !bDouble) {	//   ~~~ // /*�� ���� ��츦 �����ϱ� ����. bLineCmt�� ����ǰ� �� ���� bMLineCmt�� ����ó���� ����� �Ѵ�.
				slash_case(&check_stack, &bLineCmt, &bMLineCmt,memory);
			}
			break;

		case '*':
			asterisk_case(&check_stack, &bMLineCmt);
			break;

		case '\n':
			nLine++;
			bLineCmt = FALSE;	//	���� ���� �������� ��·�� // �ּ� ��� ����
			break;

		case '(': case '{':	case '[':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	����ǥ, �ּ� �ƴҶ��� (,{,[ �� ����ִ´�.
				parenthesesCount++;	//	��ȣ���� ����̳� �������� ����� �; count
				parentheses_open(&stack,&check_stack, ch);
			}
			break;

			/* �Ʒ����ʹ� �ݴ� �κ� */

		case ')':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	����ǥ, �ּ� �ƴҶ��� ),},] �� ����ִ´�.
				parentheses_close(&stack, '(', ')');
			}
			break;

		case '}':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	����ǥ, �ּ� �ƴҶ��� ),},] �� ����ִ´�.
				parentheses_close(&stack, '{', '}');
			}
			break;

		case ']':
			if (!bSingle && !bDouble && !bLineCmt && !bMLineCmt) {	//	����ǥ, �ּ� �ƴҶ��� ),},] �� ����ִ´�.
				parentheses_close(&stack, '[', ']');
			}
			break;
		}
		memory = ch;
	}

	fclose(fp);
	printf("\n[%s] File check result:\n", filename);
	if (!isEmpty(&stack)) {
		printf("  Error found (#line=%d, #char=%d)\n\n", nLine, nChar);
		display(&stack, filename);
	}
	else
		printf("  Ok (#line=%d, #char=%d)\n", nLine, nChar);
	
	printf("\n  ¦ ���� ��ȣ ���� : %d\n\n", parenthesesCount);
	fclose(fp);

	return isEmpty(&stack);
}

/*	')','}',']' case�� ����Ǵ� �Լ�	 */
void parentheses_close(Stack *stack, char open, char close) {
	if (peek(stack) == open) {	//	¦ ã�Ҵ�
		pop(stack);		//  ����
	}
	else {		// ���⿡ ������ ������ errorǥ��
		push(stack, close);	
	}
	return;
}

/*	 '(','{','[' case�� ����Ǵ� �Լ�	 */
void parentheses_open(Stack *stack,Stack *check_stack, char open) {
	if (peek(check_stack) == '/') {	//	���� /( �Ͱ��� ���ڰ� ���ӵǼ� ���ÿ� '/' '('�� �´ٸ� ������ �� �� �����Ƿ�,
		pop(check_stack);
		push(stack, open);	//	���� �� �ִ� '/' '*' '(' '{' '[' ���� �Էµ� �� '/' ������ '*'�� '/'�� �ƴϸ� pop�ع����� ����
	}
	else {						//	'/'�� �ƴϳ�?
		push(stack, open);		//	���� ���� ��ȣ�� �־�д�.
	}
	return;
}

/*		 '*' case�� ����Ǵ� �Լ�		 */
void asterisk_case(Stack *stack, boolean *bMLineCmt) {
	/* bMLineCmt�� ���ۉ�ٸ� */
	if (*bMLineCmt) {		//	/* �ּ� �����ϰ��� *�� ������
		push(stack, '*');	//	�ϴ� Stack�� �ִ´�. 
	}
	/* bMLineCmt�� ������ �ȉ�ٸ� */
	else {
		if (peek(stack) == '/') {	//	/*�� ���Ӊ�ٸ�!
			*bMLineCmt = TRUE;	//	/* �ּ��̴�!	
			push(stack, '*');	//  /*�� �´ٴ� ���� �Ǵ� ������ �ٽ� '/'�� '*'��	
								//	push ���ش�.
		}	//	'*'�� ���Դµ� �տ��� '/'�� �ƴϸ�, �׳� �Ѿ�� ��. -> ���� else ������	
	}
	return;
}

/*		 '/' case�� ����Ǵ� �Լ�	     */
void slash_case(Stack *stack, boolean *bLineCmt, boolean *bMLineCmt,Element memory) {
	/* bMLineCmt�� ���ۉ�ٸ� bMLineCmt�� ���� �� �ִ� �κ��̴�. */
	if (*bMLineCmt) {
		if (memory == '*') {	//	/*�� ���۵Ǿ��� �տ� *�� �԰� ���� / �� ������ bMLineCmt�� ���� ���� ���.
			pop(stack);	//	peek�� �ؿ��� '*'�� �ִ����� ���� ���� pop()
			if (peek(stack) == '*') {		//	�ֳ��ϸ� /*/�� ��츦 ����
				*bMLineCmt = FALSE;			//	/* ~ */�� ������ �κ��̴�.
				while (pop(stack) != '/');	//	'/'�� ���ö����� pop()�� �Ѵ�.
			}
			else {
				push(stack, '*');		//	/*/�̴�! bMLineCmt �������� �ƴϴ�. -> ���� *�� �ٽ� �ִ´�.
			}
		}
	}
	/* bMLineCmt�� ���� �� �� ��� �κ� */
	else {
		if (peek(stack) == '/') {	//	// �� ���Ӊ�ٸ�!
			pop(stack);
			*bLineCmt = TRUE;	//	// �ּ��̴�!
		}
		else {						//	�����ô��� �տ��� /�� �ƴϴ�!
			push(stack, '/');		//	��� ���� '/'�� ���ÿ� �־�д�.
		}
	}
	return;
}