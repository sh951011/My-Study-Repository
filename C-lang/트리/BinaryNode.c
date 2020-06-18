/*
		KwangWoon University
		������Ű��а� 2014707073 ���ȯ
		�ڷᱸ�� �� �˰��� Homework#2
*/

#include "BinaryNode.h"

// ================================================
// ���� ���Ǹ� ���� ���ǵ�
#define TRUE 1
#define FALSE 0
#define MAX(a,b)	((a) > (b) ? (a) : (b))
#define SUM(a,b)	(a + b)
#define isNULL(n)	(n == NULL)
#define notNULL(n)	(n != NULL)
#define and	&&
typedef int boolean;

/* �ܸ���� ���� ��ȯ */
boolean	isLeaf(TNode* n) {
	return (isNULL(n->left) and isNULL(n->right)); 
}

/* ���ο� ��� ���� */
TNode* newNode(TreeData val, TNode* l, TNode* r) {
	TNode* n = (TNode*) malloc(sizeof(TNode));
	n->data = val;
	n->left = l;
	n->right = r;
	return n;
}

/* Ʈ���� ��� ���� ��� */
int countNode(TNode *n) {
	if (isNULL(n)) return 0;
	return 1 + SUM(countNode(n->left), countNode(n->right));
}

/* Ʈ���� �ܸ���� ���� ��� */
int countLeaf(TNode *n) {
	if (isNULL(n)) return 0;
	else if (isNULL(n->left) and isNULL(n->right)) return 1;
	else return SUM(countLeaf(n->left), countLeaf(n->right));
}

/* Ʈ���� ���� ��� */
int calcHeight(TNode *n) {
	if (isNULL(n)) return 0;
	else return 1 + MAX(calcHeight(n->left),calcHeight(n->right));
}

/* ���� ��ȸ */
void inorder(TNode *n) {
	if (notNULL(n)) {
		inorder(n->left);
		printTData(n->data);
		inorder(n->right);
	}
}

/* ���� ��ȸ */
void preorder(TNode *n) {
	if (isNULL(n)) return;
	printTData(n->data);
	preorder(n->left);
	preorder(n->right);
}

/* ���� ��ȸ */
void postorder(TNode *n) {
	if (isNULL(n)) return;
	postorder(n->left);
	postorder(n->right);
	printTData(n->data);
}