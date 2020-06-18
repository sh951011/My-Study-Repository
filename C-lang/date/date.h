#include <stdio.h>

#define january 31
#define february 28
#define march 31
#define april 30
#define may 31
#define june 30
#define july 31
#define august 31
#define september 30
#define october 31
#define november 30
#define december 31

struct _compareDate {
	int born_Year, born_Month, born_Date;
	int compare_Year, compare_Month, compare_Date;
}date;

void inputDateUserWereBorn(struct _compareDate *date);
void inputDateToCompare(struct _compareDate *date);
int calculateYear(struct _compareDate *date);
int calculateDifferenceDate(struct _compareDate *date);
int bornMoveTo_7_1(struct _compareDate *date);
int compareMoveTo_7_1(struct _compareDate *date);
int howManyLeapYear(struct _compareDate *date);

/* �¾ ��¥ �Է� �޴� �Լ� */
void inputDateUserWereBorn(struct _compareDate *date) {
	printf("Enter a year you were born : ");
	scanf_s("%d", &(date->born_Year));
	do {
		printf("Enter a month you were born (1~12) : ");
		scanf_s("%d", &(date->born_Month));
	} while (date->born_Month <0 || date->born_Month>12);
	do {
		printf("Enter a date you were born (1~31) : ");
		scanf_s("%d", &(date->born_Date));
	} while (date->born_Date<0 || date->born_Date>31);

	return;
}

/* ���� ��¥ �Է� �޴� �Լ� */
void inputDateToCompare(struct _compareDate *date) {
	do {
		printf("Enter a year compare to  : ");
		scanf_s("%d", &(date->compare_Year));
	} while (date->compare_Year < date->born_Year);
	do {
		printf("Enter a month compare to (1~12) : ");
		scanf_s("%d", &(date->compare_Month));
	} while (date->compare_Month<0 || date->compare_Month>12);
	do {
		printf("Enter a date compare to : (1~31)");
		scanf_s("%d", &(date->compare_Date));
	} while (date->compare_Date<0 || date->compare_Date>31);

	return;
}


/* �⵵ ���̸� ����ϴ� �Լ� */
int calculateYear(struct _compareDate *date) {
	int difference_Year = 0;

	difference_Year = (date->compare_Year) - (date->born_Year);

	return difference_Year;
}

/* �¾ ��¥�� �ش� �⵵ 7��1�ϰ� �󸶳� ���̳����� ��� */
int bornMoveTo_7_1(struct _compareDate *date) {
	int returnValue = 0;

	/*
	�¾ ��¥�� 7�� 1�� �������� �� ���� ��¥��� ��, if (date->born_Month>7) �̶��,
	�¾ ��¥ �������� 7�� 1�Ϸ� �̵� ��, ���Ϸ��� �⵵�� 7�� 1�ϰ��� ��¥ ���̸� ����� ��
	�ᱹ�� ���־�� �ϹǷ� returnValue�� ���������� ��ȯ���ش�.

	�ݴ��, �¾ ��¥�� 7�� 1���� ���� �� �� ��¥��� ��, else�� �����
	�¾ ��¥ �������� 7�� 1�Ϸ� �̵��� �� ���Ϸ��� �⵵�� 7�� 1�ϰ��� ��¥ ���̸� ����� ��
	�����־�� �ϹǷ�, returnValue���� �״�� �д�.
	*/
	if (date->born_Month>7) {
		if (date->born_Month == 8) {
			/* �ش� �� 1�Ϸ� (date->born_Date - 1) �� �� 7������ �� ���� ���� ������ */
			/* �� 7�� 1�ϱ����� ��¥ ��� */
			returnValue = (july + (date->born_Date - 1));	
		}
		else if (date->born_Month == 9) {
			returnValue = (july + august+ (date->born_Date - 1));
		}
		else if (date->born_Month == 10) {
			returnValue = (july + august + september + (date->born_Date - 1));
		}
		else if (date->born_Month == 11) {
			returnValue = (july +august +september +
				          +october + (date->born_Date - 1));
		}
		else if (date->born_Month == 12) {
			returnValue = (july +august + september +
				+october + november + (date->born_Date - 1));
		}
		returnValue = (-returnValue);	

		return returnValue;
	}
	else if (date->born_Month==7) {
		returnValue = date->born_Date - 1;
		returnValue = (-returnValue);
		
		return returnValue;
	}
	else {
		if (date->born_Month == 1) {
			/* �ش� �� 1�Ϸ� (date->born_Date - 1) �� �� 7������ �� ���� ���� ������ */
			returnValue = (january + february + march + april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 2) {
			returnValue = (february +march + april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 3) {
			returnValue = (march +april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 4) {
			returnValue = (april + may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 5) {
			returnValue = (may + june - (date->born_Date - 1));
		}
		else if (date->born_Month == 6) {
			returnValue = (june - (date->born_Date - 1));
		}

		return returnValue;
	}
}

/* ���� ��¥�� �ش� �⵵ 7��1�ϰ� �󸶳� ���̳����� ��� */
int compareMoveTo_7_1(struct _compareDate *date) {
	int returnValue = 0;

	/*
	���� ��¥�� 7�� 1�Ϻ��� �� ���� ��¥���, �����־�� �ϹǷ� +
	7�� 1�Ϻ��� �� ���� ��¥��� ���־�� �ϹǷ� -
	*/

	if (date->compare_Month > 7) {
		if (date->compare_Month == 8) {
			/* �ش� �� 1�Ϸ� (date->compare_Date - 1) �� �� 7������ �� ���� ���� ������ */
			/* �� 7�� 1�ϱ����� ��¥ ��� */
			returnValue = (july + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 9) {
			returnValue = (july + august + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 10) {
			returnValue = (july + august + september + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 11) {
			returnValue = (july + august + september +
				+ october + (date->compare_Date - 1));
		}
		else if (date->compare_Month == 12) {
			returnValue = (july + august + september +
				+october + november + (date->compare_Date - 1));
		}

		return returnValue;
	}
	else if (date->compare_Month == 7) {
		returnValue = date->compare_Date - 1;

		return returnValue;
	}
	else {
		if (date->compare_Month == 1) {
			/* �ش� �� 1�Ϸ� (date->born_Date - 1) �� �� 7������ �� ���� ���� ������ */
			returnValue = (january + february + march + april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 2) {
			returnValue = (february + march + april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 3) {
			returnValue = (march + april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 4) {
			returnValue = (april + may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 5) {
			returnValue = (may + june - (date->compare_Date - 1));
		}
		else if (date->compare_Month == 6) {
			returnValue = (june - (date->compare_Date - 1));
		}

		returnValue = (-returnValue);

		return returnValue;
	}
}

/* ���������� ������ִ� �Լ� */
int calculateDifferenceDate(struct _compareDate *date) {
	int difference = 0;

	/* (���̳��� �⵵ x 365) + (���Ϸ��� ��¥�� �ش�⵵ 7��1�ϰ��� ����) + (�¾ ��¥�� �ش�⵵ 7�� 1�ϰ��� ����) +1(�¾��) */
	difference = (365 * calculateYear(date)) + compareMoveTo_7_1(date) + bornMoveTo_7_1(date) + howManyLeapYear(date) +1;
	
	return difference;
}

/* �Է¹��� �� ��¥ ���̿� ������ �󸶳� �־����� ������ִ� �Լ� */
int howManyLeapYear(struct _compareDate *date) {
	int numOfLeapYear = 0;

	for (int i = date->born_Year; i <= date->compare_Year; i++) {
		/* �¾ ���� 2�� ���Ķ�� �¾ �⵵ ������� ���x -> i==date->born_Year�� ���� skip */
		if (date->born_Month>2) {
			if (i == date->born_Year) {
				continue;
			}
			else {
				/* ���Ϸ��� ���� 2�� ���Ķ�� ����� ���o*/
				if (date->compare_Month>2) {
					/* �����̸� */
					if (((i % 4 == 0) && (i % 100 != 0)) || (i%400==0)) {
						numOfLeapYear++;
					}
				}
				/* ���Ϸ��� ���� 2���̰ų� 2�� ���̶�� ����� ���x */
				else {
					if (i == date->compare_Year) {
						continue;
					}
					/* �����̸� */
					if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
						numOfLeapYear++;
					}
				}
			}
		}
		/* �¾ ���� 2�� �����̶�� ����� ���o -> i==date->born_Year�� ���� ���� */
		else {
			/* ���Ϸ��� ���� 2�� ���Ķ�� ����� ���o*/
			if (date->compare_Month > 2) {
				/* �����̸� */
				if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
					numOfLeapYear++;
				}
			}
			/* ���Ϸ��� ���� 2���̰ų� 2�� ���̶�� ����� ���x */
			else {
				if (i == date->compare_Year) {
					continue;
				}
				/* �����̸� */
				if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
					numOfLeapYear++;
				}
			}
		}
	}

	return numOfLeapYear;
}