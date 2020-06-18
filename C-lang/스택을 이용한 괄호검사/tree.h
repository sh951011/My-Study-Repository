/*
									2019-03-23 ~ 2019-03-24
									KwangWoon University 2014707073 ���ȯ
									c���� �����ϴ� Tree
*/

#include <stdio.h>
#include <stdlib.h>

#define MAX 30
#define TRUE 1
#define FALSE 0

typedef char element;
typedef int boolean;

typedef struct __node {
	char name[MAX];
	struct __node *left;
	struct __node *right;
	struct __node *top;
}Node;

typedef struct __tree {
	Node *seed;
	Node *current;
}Tree;

/* Ʈ���� �ù����� ����� �Լ� */
void Seed(Tree *tree);

/* Ʈ���� ��带 ����� �Լ� */
Node* MakeNode();

/* �������� ���ڿ��� �Է¹޴� �Լ� */
void InputString(char str[]);

/* Ʈ���� ������ġ���� ���� Ʈ�� ���� */
void MakeSubTree(Tree *tree);

/* ������ġ(current)�� Ʈ�� �����Ҵ� ���� */
void DeleteCurrentTree(Tree *tree);

/* ������ġ�� ���� Ʈ���� �����Ҵ� ���� */
void DeleteSubTree(Tree *tree);

/* Ʈ�� �۵� Ȯ�ο� */
void TestTree(Tree *tree);

/* �������� �����ִ� UI */
int ShowChoiceList();

/* ���ο� ��带 ����� �ش� ��� �����͸� ��ȯ */
Node* MakeNode() {
	return (Node*)calloc(1, sizeof(Node));
}

/* Ʈ�� seed�� ����� �Լ� */
void Seed(Tree *tree) {
	tree->seed = MakeNode();
	printf("Seed Name : ");
	InputString(tree->seed->name);
	tree->seed->left = NULL;
	tree->seed->right = NULL;
	tree->seed->top = NULL;
	return;
}

/* ���� Ʈ���� ����� �Լ� */
void MakeSubTree(Tree *tree) {
	if (tree->current->left != NULL) {
		printf("Left Tree Exist!!\n");
	}
	else {
		tree->current->left = MakeNode();
		tree->current->left->top = tree->current;
		printf("Left Tree Name : ");
		while (getchar() != '\n');
		InputString(tree->current->left->name);
	}
	if (tree->current->right != NULL) {
		printf("Right Tree Exist!!\n");
	}
	else {
		tree->current->right = MakeNode();
		tree->current->right->top = tree->current;
		printf("Right Tree Name : ");
		InputString(tree->current->right->name);
	}
	return;
}



/* ���ڿ��� �Է¹޾Ƽ� char �迭�� �־��ִ� �Լ� */
void InputString(char str[]) {
	char ch = '\0';
	int i = 0;
	while (ch != '\n') {
		ch = getchar();
		str[i++] = ch;
	}
	return;
}

/* Tree �̸��� print�ϴ� �Լ� */
void PrintName(Tree tree) {
	char ch = '\0';
	int i = 0;
	while(1){
		printf("%c", tree.current->name[i++]);
		if (tree.current->name[i] == '\n') {
			printf("\n");
			return;
		}
	}
}

/* ���� ������ printf */
void PrintSubTree(Tree tree) {
	char ch = '\0';
	int i = 0;

	if (tree.current->left == NULL || tree.current->right == NULL) {
		puts("\n���� ������ �����ϴ�!!\n");
		return;
	}

	while (1) {
		if (tree.current->left->name[i] == '\n') {
			printf("\t");
			break;
		}
		printf("%c", tree.current->left->name[i++]);
	}
	i = 0;
	while (1) {
		if (tree.current->right->name[i] == '\n') {
			printf("\n");
			break;
		}
		printf("%c", tree.current->right->name[i++]);
	}
}

/* Tree ����Ȯ�ο� */
void TestTree(Tree *tree) {
	tree->current = tree->seed;
	int choice = 0;

	while (TRUE) {
		do {
			choice = ShowChoiceList();
		} while (choice < 1 || choice>8);

		switch (choice) {
		case 1:
			tree->current = tree->current->left;
			break;
		case 2:
			tree->current = tree->current->right;
			break;
		case 3:
			PrintSubTree(*tree);
			break;
		case 4:
			MakeSubTree(tree);
			break;
		case 5:
			tree->current = tree->current->top;
			break;
		case 6:
			DeleteSubTree(tree);
			break;
		case 7:
			PrintName(*tree);
			break;
		case 8:
			DeleteCurrentTree(tree);
			return;
		}
	}
}

/* ���ÿ� list */
int ShowChoiceList() {
	int choice;
	puts("\n>>> 1. ���� Tree�� ����\n");
	puts(">>> 2. ������ Tree�� ����\n");
	puts(">>> 3. ���� Tree ���\n");
	puts(">>> 4. ���� Tree �����\n");
	puts(">>> 5. ���� Tree��\n");
	puts(">>> 6. ���� Tree ����\n");
	puts(">>> 7. ���� Tree ���\n");
	puts(">>> 8. ����\n");
	scanf_s("%d", &choice);
	return choice;
}

/* ���� current tree �����Ҵ� ���� */
void DeleteCurrentTree(Tree *tree){
	free(tree->current);
}

/* ���� current tree�� sub tree �����Ҵ� ���� */
void DeleteSubTree(Tree *tree) {
	free(tree->current->left);
	free(tree->current->right);
	return;
}