/*
������б� 18�⵵ 2�б� ���м���2 HomeWork10
2014707073 ���ȯ
NxN����� ����� ���ϱ� �� Ȯ��
*/
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

time_t s1, s2;

void printMatrix(int** matrix, int size);
int det2(int** matrix);
int makeSMatrix(int **matrix, int size, int x, int y);
int determinant(int** matrix, int size);
int isOdd(int i, int j);
int adjoint(int** matrix, int size);
void makeInverseMatrix(float** inverseMatrix, int** matrix, int det, int size);
void printMatrixFloat(float** matrix, int size);
void checkMatrix(float** inverseMatrix, int** originMatrix, int size);
float mulMatrix(int** matrix, float** inverseMatrix, int size, int i, int j);
float mulInverseMatrix(int** matrix, float** inverseMatrix, int size, int i, int j);
void checkInverseMatrix(float** inverseMatrix, int** originMatrix, int size);
void inputMatrixValue(int** matrix, int size);
void makeInverseMatrixSize2(float** inverseMatrix, int** copyOriginMatrix, int det, int size);

void main() {
	time(&s1);
	int size = 0;
	int det;
	double takeTime = 0.0;
	int** originMatrix;	//	������ ���
	float** inverseMatrix;	//	�����
	int** copyOriginMatrix;	//	������� ����
	int i = 0, j = 0;

	printf("��� ũ�� : ");
	scanf_s("%d", &size);

	/* ��ĵ� �����Ҵ� */

	originMatrix = (int**)malloc(sizeof(int*)*size);
	for (i = 0; i < size; i++) {
		originMatrix[i] = (int*)malloc(sizeof(int)*size);
	}

	inverseMatrix = (float**)malloc(sizeof(float*)*size);
	for (i = 0; i < size; i++) {
		inverseMatrix[i] = (float*)malloc(sizeof(float)*size);
	}
	/* ��ĵ� �����Ҵ� */


	inputMatrixValue(originMatrix, size);
	printf("## ���� ���\n\n");
	printMatrix(originMatrix, size);
	printf("## determinant : ");
	copyOriginMatrix = copyMatrix(originMatrix, size);
	det = determinant(originMatrix, size);
	printf("%d\n\n\n", det);

	if (determinant == 0) {
		printf("## ������� �������� �ʽ��ϴ�!!\n");
		time(&s2);
		takeTime = difftime(s2, s1);
		printf("�ɸ� �ð� : %f\n", takeTime);
		return;
	}
	else {
		if (size == 2) {
			makeInverseMatrixSize2(inverseMatrix, copyOriginMatrix, det, size);
		}
		else {
			copyOriginMatrix = adjoint(copyOriginMatrix, size);
			makeInverseMatrix(inverseMatrix, copyOriginMatrix, det, size);
		}
		printf("## �����\n\n");
		printMatrixFloat(inverseMatrix, size);
		checkMatrix(inverseMatrix, originMatrix, size);
		checkInverseMatrix(inverseMatrix, originMatrix, size);
		time(&s2);
		takeTime = difftime(s2, s1);
		printf("�ɸ� �ð� : %f\n", takeTime);
		return;
	}
}

/* ����� 2�϶��� ����� ���� */
void makeInverseMatrixSize2(float** inverseMatrix, int** copyOriginMatrix, int det, int size) {
	int i = 0, j = 0;

	inverseMatrix[0][0] = (float)copyOriginMatrix[1][1];
	inverseMatrix[0][1] = -(float)copyOriginMatrix[0][1];
	inverseMatrix[1][0] = -(float)copyOriginMatrix[1][0];
	inverseMatrix[1][1] = (float)copyOriginMatrix[0][0];

	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			inverseMatrix[i][j] = ((inverseMatrix[i][j]) / (float)det);
		}
	}

	return;
}

void inputMatrixValue(int** matrix, int size) {
	int n = 0;
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			printf("%d�� %d���� ���Ҹ� �Է����ּ��� : ", i + 1, j + 1);
			scanf_s("%d", &n);
			matrix[i][j] = n;
		}
	}


	return;
}

void printMatrix(int** matrix, int size) {
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			printf("%d\t", matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

void printMatrixFloat(float** matrix, int size) {
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			printf("%f\t", matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

int copyMatrix(int** originMatrix, int size) {
	int** copyOriginMatrix;
	int i = 0, j = 0;

	copyOriginMatrix = (int**)malloc(sizeof(int*)*size);
	for (i = 0; i < size; i++) {
		copyOriginMatrix[i] = (int*)malloc(sizeof(int)*size);
	}


	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			copyOriginMatrix[i][j] = originMatrix[i][j];
		}
	}

	return copyOriginMatrix;
}

int det2(int** matrix) {
	int det;

	det = matrix[1][1] * matrix[0][0] - matrix[1][0] * matrix[0][1];	//	ad-bc

	return det;
}

int makeSMatrix(int **matrix, int size, int x, int y) {
	int** sMatrix;
	int i = 0, j = 0, newI = 0, newJ = 0;
	/*
	�������� x,y ��� ���� �Է����ڷ� ������
	���ο� �迭�� ���� ��� size���� ������� �ϳ��� �۾ƾ� �ϹǷ� �����Ҵ����� size-1�� �������ش�.
	�׸��� matrix�� ���ҵ��� newMatrix�� ���ҷ� �־��ִµ� �������ִ� x,y�ٿ� �ش��Ѵٸ� �׳� �Ѿ���� ���ش�
	*/

	sMatrix = (int**)malloc(sizeof(int*)*(size - 1));
	for (i = 0; i < size - 1; i++) {
		sMatrix[i] = (int*)malloc(sizeof(int)*(size - 1));
	}

	for (i = 0, newI = 0; i < size; i++) {
		if (i == x) {
			continue;
		}
		for (j = 0, newJ = 0; j < size; j++) {
			if (j == y) {
				continue;
			}
			else {
				sMatrix[newI][newJ] = matrix[i][j];
				newJ++;
			}
		}
		newI++;
	}
	return sMatrix;
}

int determinant(int** matrix, int size) {
	int det = 0;
	int i = 0, j = 0;

	for (i = 0; i < size; i++) {
		if (isOdd(0, i)) {
			if (size == 3) {
				det -= matrix[0][i] * det2(makeSMatrix(matrix, size, 0, i));
			}
			else if (size == 2) {
				det = det2(matrix);
			}
			else {
				det -= matrix[0][i] * determinant(makeSMatrix(matrix, size, 0, i), size - 1);
			}
		}
		else {
			if (size == 3) {
				det += matrix[0][i] * det2(makeSMatrix(matrix, size, 0, i));
			}
			else if (size == 2) {
				det = det2(matrix);
			}
			else {
				det += matrix[0][i] * determinant(makeSMatrix(matrix, size, 0, i), size - 1);
			}
		}
	}

	return det;
}

int isOdd(int i, int j) {
	if ((i + j) % 2) return 1;
	else return 0;
}

int adjoint(int** matrix, int size) {
	int** copyOriginMatrix;
	int i = 0, j = 0;
	copyOriginMatrix = copyMatrix(matrix, size);	//	�⺻ ��� ī��
	/*
	adjoint����� ����� ���ؼ���
	�� ��ľ��� ������ ��� ���� ������ sMatrix�Լ��� ����� �ش� sMatrix�Լ������Ͽ� determinant�� �Ѵ�.
	�� determinant�� �� ���鿡 ���Ͽ� ��� ���� ���� ¦����� ���ǰ�, Ȧ����� ���������� �ٲ��ش�.
	�� �迡�� ���� ��ĵ鿡 ���Ͽ� transpose���ش�.
	*/

	/* �� ��ľ��� ������ ��� ���� ������ sMatrix�Լ��� ����� �ش� sMatrix�Լ������Ͽ� determinant�� �Ѵ�. */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			if (size == 3) {	//	����
				copyOriginMatrix[i][j] = det2(makeSMatrix(matrix, size, i, j));
			}
			else {
				copyOriginMatrix[i][j] = determinant(makeSMatrix(matrix, size, i, j), size - 1);
			}
		}
	}

	/* �� determinant�� �� ���鿡 ���Ͽ� ��� ���� ���� ¦����� ���ǰ�, Ȧ����� ���������� �ٲ��ش�. */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			if (isOdd(i, j)) {
				copyOriginMatrix[i][j] = (-copyOriginMatrix[i][j]);
			}
		}
	}

	/* �� �迡�� ���� ��ĵ鿡 ���Ͽ� transpose���ش�. */
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			matrix[i][j] = copyOriginMatrix[j][i];
		}
	}

	return matrix;
}

void makeInverseMatrix(float** inverseMatrix, int** matrix, int det, int size) {
	int i = 0, j = 0;
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			inverseMatrix[i][j] = ((float)matrix[i][j] / (float)det);
		}
	}

	return;
}

void checkMatrix(float** inverseMatrix, int** originMatrix, int size) {
	float** resultMatrix;
	int i = 0, j = 0;
	resultMatrix = (float**)malloc(sizeof(float*)*size);
	for (i = 0; i < size; i++) {
		resultMatrix[i] = (float*)malloc(sizeof(float)*size);
	}

	printf("## ���ϱ�\n\n");
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			resultMatrix[i][j] = mulMatrix(originMatrix, inverseMatrix, size, i, j);
		}
	}

	printMatrixFloat(resultMatrix, size);
}

float mulMatrix(int** matrix, float** inverseMatrix, int size, int i, int j) {
	float result = 0;
	int k = 0;
	for (k = 0; k < size; k++) {
		result += (matrix[i][k] * inverseMatrix[k][j]);
	}

	return result;
}

float mulInverseMatrix(int** matrix, float** inverseMatrix, int size, int i, int j) {
	float result = 0;
	int k = 0;
	for (k = 0; k < size; k++) {
		result += (inverseMatrix[k][j] * matrix[i][k]);
	}

	return result;
}

void checkInverseMatrix(float** inverseMatrix, int** originMatrix, int size) {
	float** resultMatrix;
	int i = 0, j = 0;
	resultMatrix = (float**)malloc(sizeof(float*)*size);
	for (i = 0; i < size; i++) {
		resultMatrix[i] = (float*)malloc(sizeof(float)*size);
	}

	printf("## �ݴ�ΰ��ϱ�\n\n");
	for (i = 0; i < size; i++) {
		for (j = 0; j < size; j++) {
			resultMatrix[i][j] = mulInverseMatrix(originMatrix, inverseMatrix, size, i, j);
		}
	}

	printMatrixFloat(resultMatrix, size);
}