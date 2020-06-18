#ifndef BINARY_NODE_H
#define BINARY_NODE_H

#include <stdio.h>
#include <stdlib.h>

// ����ü ���� ������� ����.
#define TreeData int
#define printTData(e) printf("[%c] ", e)

typedef struct BinTrNode {
	TreeData			data;		// ������ �ʵ�
	struct BinTrNode*	left;		// ���� �ڽ�
	struct BinTrNode*	right;		// ������ �ڽ�
} TNode;

extern TNode* newNode(TreeData val, TNode* l, TNode* r);
extern int	isLeaf(TNode* n);

extern int	countNode(TNode *n);
extern int	countLeaf(TNode *n);
extern int	calcHeight(TNode *n);

extern void	inorder(TNode *n);
extern void	preorder(TNode *n);
extern void	postorder(TNode *n);

#endif

