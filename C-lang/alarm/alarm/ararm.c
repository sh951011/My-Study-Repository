#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <time.h>	/* �ð� �� ��¥ ���� #include */
#include <string.h>	/* ���ڿ� ���� #include */

void main() {
	FILE* file;	// ���� �����
	struct tm* now = NULL;	// time���� �����ϴ� ����ü
	time_t now_t = NULL;	
	time(&now_t);	//	����ð� ����
	char str[100] = {NULL,};

	now = localtime(&now_t);	//	�� ������ �ð����� ������Ʈ

	int year = now->tm_year + 1900;	//	���� �⵵�ε�, 1900�⵵���� count�ϹǷ�, + 1900
	int month = now->tm_mon+1;	//	0~11�� ������ �Ǿ��ֱ� ������ +1
	int day = now->tm_mday;	//	�׳� ���� ��¥
	int hour = now->tm_hour;	//	���� �ð�
	int minute = now->tm_min;	// ���� ��
	char s1[5];
	char read[100] = { NULL, };

	file = fopen("test.txt", "w");	// ���� ������� open
	if (hour > 12) {	//	�ð��� 12�� ������ ���� �� 12�� ����!
		hour -= 12;
		strcat(str, "���� ");
	}
	else strcat(str, "���� ");
	sprintf(s1, "%d", hour);	// int���� char �迭�� ����
	strcat(str, s1);
	strcat(str, " : ");
	sprintf(s1, "%d", minute);	// int���� char �迭�� ����
	strcat(str, s1);
	strcat(str, "  ");
	sprintf(s1, "%d", year);	// int���� char �迭�� ����
	strcat(str, s1);
	if(month>10)
		strcat(str, "-0");
	else
		strcat(str, "-");
	sprintf(s1, "%d", month);	// int���� char �迭�� ����
	strcat(str, s1);
	strcat(str, "-");
	sprintf(s1, "%d", day);	// int���� char �迭�� ����
	strcat(str, s1);
	strcat(str, "\n\0");
	fwrite(str, sizeof(char) * 100, 1, file);

	fclose(file);

	file = fopen("test.txt", "r");

	time(&now_t);	//	����ð� ����
	now = localtime(&now_t);	//	�� ������ �ð����� ������Ʈ

	year = now->tm_year + 1900;
	month = now->tm_mon + 1;
	day = now->tm_mday;
	hour = now->tm_hour;
	minute = now->tm_min;
	
	for (int i = 0; i < 100; i++) {
		str[i] = NULL;
	}

	if (hour > 12) {
		hour -= 12;
		strcat(str, "���� ");
	}
	else strcat(str, "���� ");
	sprintf(s1, "%d", hour);
	strcat(str, s1);
	strcat(str, " : ");
	sprintf(s1, "%d", minute);
	strcat(str, s1);
	strcat(str, "  ");
	sprintf(s1, "%d", year);
	strcat(str, s1);
	if (month > 10)
		strcat(str, "-0");
	else

		strcat(str, "-");
	sprintf(s1, "%d", month);
	strcat(str, s1);
	strcat(str, "-");
	sprintf(s1, "%d", day);
	strcat(str, s1);
	strcat(str, "\n\0");

	fread(read, sizeof(char), 100, file);
	printf("�ؽ�Ʈ ���� : %s\n",read);
	printf("���� : %s\n", str);

	fclose(file);

	return;
}