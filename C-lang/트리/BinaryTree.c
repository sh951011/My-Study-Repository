/*
		KwangWoon University
		������Ű��а� 2014707073 ���ȯ
		�ڷᱸ�� �� �˰��� Homework#2
*/

#include "BinaryTree.h"
#include "CircularQueue.h"	// ������ȸ: ������ circular queue �ڵ� Ȱ��

// ===============================================================
// ���� ���Ǹ� ���� ���ǵ�
#define TRUE 1
#define FALSE 0
#define isNULL(n)	(n == NULL)
#define notNULL(n)	(n != NULL)
#define isExist(q)	!isEmpty(&q)
#define LineAlignment	printf("\n")
#define nulloc(e)	e = NULL;
#define SHIFT(n)	(1<<n)
#define and &&
#define or ||


typedef int boolean;

void initTree( BinTree* t )	{ nulloc(t->root); }

//================================================================
// Ʈ���� �⺻���� ���� ���
int	getCount(BinTree* t)	{ return countNode(t->root); }
int	getLeafCount(BinTree* t){ return countLeaf(t->root); }
int	getHeight(BinTree* t)	{ return calcHeight(t->root); }

//================================================================
// Ʈ���� ��ȸ
void printInOrder(BinTree* t)	{ printf("   inorder: "); inorder(t->root); printf("\n"); }
void printPreOrder(BinTree* t)	{ printf("  preorder: "); preorder(t->root); printf("\n"); }
void printPostOrder(BinTree* t)	{ printf(" postorder: "); postorder(t->root);  printf("\n"); }

/* ���� ��ȸ */
void printLevelOrder(BinTree* t) {
	Queue q;
	initQueue(&q);
	TNode *ptr = t->root;

	if (isNULL(t)) return;
	printf("levelorder: ");
	enqueue(&q, ptr);
	while (isExist(q)) {
		ptr = dequeue(&q);
		printf("[%c] ",ptr->data);
		if (ptr->left)
			enqueue(&q, ptr->left);
		if (ptr->right)
			enqueue(&q, ptr->right);
	}
	LineAlignment;
}

//================================================================
// ��������Ʈ�� ���� �˻�
boolean isFullTree(BinTree* t) {
	boolean ret = TRUE;
	Queue q;
	initQueue(&q);
	TNode *ptr = t->root;
	boolean flag = TRUE;	//	������� �������϶� TRUE!
							//	������� ���������, NULL�� ���� ���� FALSE!
							//	FALSE�϶� ������ȸ�� �Ͽ�, ���� �����Ͱ� �����Ѵٸ� ��������Ʈ���� �ƴϴ�!

	if (isNULL(t))
		return TRUE;

	enqueue(&q, ptr);
	while (isExist(q)) {
		ptr = dequeue(&q);
		if (flag) {
			if (notNULL(ptr->left and notNULL(ptr->right))) {
				enqueue(&q, ptr->left);
				enqueue(&q, ptr->right);
			}
			else if (isNULL(ptr->left) and notNULL(ptr->right)) {
				ret = FALSE;
				break;
			}
			else if (notNULL(ptr->left) and isNULL(ptr->right)) {
				enqueue(&q, ptr->left);
				flag = FALSE;
			}
			else if (isNULL(ptr->left) and isNULL(ptr->right)) {
				flag = FALSE;
			}
		}
		else {
			if (notNULL(ptr->left) or notNULL(ptr->right)) {
				ret = FALSE;
				break;
			}
		}
	}

	if (ret) printf("\n���� ���� Ʈ���Դϴ�.\n\n");
	else printf("\n���� ���� Ʈ���� �ƴմϴ�.\n\n");
	return ret;
}

//================================================================
// ����� ���� ���
int calcLevel(BinTree* t, TNode* n) {
	int level = 0;
	boolean memory_update = TRUE;
	Queue q;
	initQueue(&q);
	TNode *ptr = t->root;
	TNode *memory = NULL;
	if (isNULL(t)) return level;

	enqueue(&q, ptr);
	level++;
	while (isExist(q)) {
		ptr = dequeue(&q);
		if (memory == ptr) {
			memory_update = TRUE;
			level++;
		}

		if (ptr == n) break;
		
		if (ptr->left) {
			if (memory_update) {
				memory = ptr->left;
				memory_update = FALSE;
			}
			enqueue(&q, ptr->left);
		}
		if (ptr->right) {
			if (memory_update) {
				memory = ptr->right;
				memory_update = FALSE;
			}
			enqueue(&q, ptr->right);
		}
	}

	if (level > 0) printf("%c : ����� ������ %d.\n",n->data , level);
	else printf("Ʈ���� ���� ����Դϴ�.\n");

	return level;

}