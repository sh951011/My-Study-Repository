#ifndef BINARY_TREE_H
#define BINARY_TREE_H

#include "BinaryNode.h"

typedef struct BinaryTree {
	TNode*	root;
} BinTree;

extern void initTree( BinTree* t );

// Ʈ���� �⺻���� ���� ���
extern int	getCount(BinTree* t);
extern int	getLeafCount(BinTree* t);
extern int	getHeight(BinTree* t);

// Ʈ�� ��ȸ
extern void printInOrder(BinTree* t);
extern void printPreOrder(BinTree* t);
extern void printPostOrder(BinTree* t);
extern void printLevelOrder(BinTree* t);

// ��������Ʈ�� ���� �˻�
extern int isFullTree(BinTree* t);

// ����� ���� ���
extern int calcLevel(BinTree* t, TNode* n);

#endif

