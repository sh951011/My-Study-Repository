/*
*	KwangWoon University
*	������Ű��а� 2014707073 ���ȯ
*	2019�⵵ 1�б� �ý������α׷��� Homework#1
*/

#include <stdio.h>	/* standard input output */
#include <unistd.h>	/* read()�� ���� #include */
#include <fcntl.h>	/* open()�� ���� #include */
#include <errno.h>	/* perror()�� ���� #include */
#include <stdlib.h>	/* exit()�� ���� #include */

#define HEX 16	/* Hexa ǥ�⸦ ���� define */


/* filename[1]�� hewview�� �� �����̸����Ѱܹ޴´� */
/* argv[0]�� ���α׷����� �ǹ��ϰ�, argv[1]���� �Ѱܹ��� */
int main(int argc, char* filename[]) {
	int fd;		/* open�� file�� �����ϴ� ���� */
	unsigned char buf;	/* ���Ϸκ��� 1char ������ �о ���� ���� */
	unsigned int count = 0;	/* 1�� �����ϸ� ��츦 �����ֱ� ���� ���� */
	char str[HEX];	/* buf�� 16�� ������ �����ؼ� %x�������� */
			/* ����� ������ char������ ����ϴ� ���� */

	fd = open(filename[1], O_RDONLY);	/* open() �б⸸ �ϸ� �ǹǷ�, O_RDONLY �ɼ� */

	/* open error �߻���, ���� �˸��� ���α׷� ���� */
	if (fd == -1) {
		perror("open");
		exit(0);
	}

	/* ������ ������ ���������� �ݺ� */
	while (read(fd, &buf, sizeof(unsigned char)) > 0) {
		str[count % HEX] = buf; /* index�� 0~15�� �ݺ��ؾ� �ϹǷ� */

		/* 0 16 32 ... 16������ ���� ���� */
		if (!(count % HEX)) {
			printf("\n%.8x: %.2x", count, buf);
		}
		/* �� ���� ��� */
		else {
			/* 2�� ���� => " " : ���� ���ֱ� ���� */
			if (count % 2)
				printf("%.2x", buf);
			else
				printf(" %.2x", buf);
		}
		/* 15 30 45 ... ���� �����ϱ� ���� ������ 16���� char�� ��� */
		if (count % HEX == 15 && count != 0) {
			printf(" ");
			for (int i = 0; i < HEX; i++) {
				/* ��°����� ASCII �ڵ� ������ ��� */
				if (str[i] > 31 && str[i] < 127)
					printf("%c", str[i]);
				/* ��� �Ұ����� ASCII �ڵ� ������ ��� */
				else
					printf(".");
			}
		}

		count++;
	}
	close(fd);

	return 0;
}