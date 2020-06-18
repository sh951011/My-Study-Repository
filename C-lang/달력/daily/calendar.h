#include <stdio.h>

#define JANUARY 31		// 1�� ��¥
#define FEBRUARY 28		// 2����¥
#define MARCH 31		// 3����¥
#define APRIL 30		// 4����¥
#define MAY 31			// 5����¥
#define JUNE 30			// 6����¥
#define JULY 31			// 7����¥
#define AUGUST 31		// 8����¥
#define SEPTEMBER 30	// 9����¥
#define OCTOBER 31		// 10����¥
#define NOVEMBER 30		// 11����¥
#define DECEMBER 31		// 12����¥
#define FIRSTYEAR 1		// 1��
#define FIRSTMONTH 1	// 1��
#define FIRSTDATE 1		// 1��
#define MONDAY 1
#define TUESDAY 2
#define WEDNESDAY 3
#define THURSDAY 4
#define FRIDAY 5
#define SATURDAY 6
#define SUNDAY 7

struct _calendar {
	int monthToPrint, yearToPrint;
	int howManyDate;
}cal;

void inputToPrint(struct _calendar *cal);
int calculateDateDifference(struct _calendar *cal);
int calculateYearDifferenceToDate(struct _calendar *cal);
int calculateMonthDifferenceToDate(struct _calendar *cal);
int findFistDay(struct _calendar *cal);
void printCalendar(struct _calendar *cal);
void findHowManyDate(struct _calendar *cal);
int howManyLeapYear(struct _calendar *cal);

/* �ش� ���� ���ϱ��� �ִ��� ��� */
void findHowManyDate(struct _calendar *cal) {
	if (cal->monthToPrint == 1) {
		cal->howManyDate = JANUARY;
	}
	else if (cal->monthToPrint == 2) {
		cal->howManyDate = FEBRUARY;
	}
	else if (cal->monthToPrint == 3) {
		cal->howManyDate = MARCH;
	}
	else if (cal->monthToPrint == 4) {
		cal->howManyDate = APRIL;
	}
	else if (cal->monthToPrint == 5) {
		cal->howManyDate = MAY;
	}
	else if (cal->monthToPrint == 6) {
		cal->howManyDate = JUNE;
	}
	else if (cal->monthToPrint == 7) {
		cal->howManyDate = JULY;
	}
	else if (cal->monthToPrint == 8) {
		cal->howManyDate = AUGUST;
	}
	else if (cal->monthToPrint == 9) {
		cal->howManyDate = SEPTEMBER;
	}
	else if (cal->monthToPrint == 10) {
		cal->howManyDate = OCTOBER;
	}
	else if (cal->monthToPrint == 11) {
		cal->howManyDate = NOVEMBER;
	}
	else if (cal->monthToPrint == 12) {
		cal->howManyDate = DECEMBER;
	}
	else {
		printf("findHowManyDate Has ERROR!!!\n\n");
	}
}

/* ����ϰ� ���� �⵵�� ���� �Է¹޴� �Լ� */
void inputToPrint(struct _calendar *cal) {
	int error = 0;

	printf("����ϰ� ���� �⵵�� �Է��ϼ���. : ");
	do {
		if (error) {
			printf("=====ERROR!!=====\n");
			printf(" �ٽ� �Է��ϼ���\n");
			printf("����ϰ� ���� �⵵�� �Է��ϼ���. : ");
			error = 0;
		}
		else {
			scanf_s("%d", &(cal->yearToPrint));
			error = 1;
		}
	} while (cal->yearToPrint < 1);

	error = 0;

	printf("����ϰ� ���� ���� �Է��ϼ��� : ");
	do {
		if (error) {
			printf("=====ERROR!!=====\n");
			printf(" �ٽ� �Է��ϼ���\n");
			printf("����ϰ� ���� ���� �Է��ϼ��� : ");
			error = 0;
		}
		else {
			scanf_s("%d", &(cal->monthToPrint));
			error = 1;
		}
	} while (cal->monthToPrint < 1 || cal->monthToPrint > 12);

	return;
}

/* �Է¹��� ��,���� 1��1��1�ϰ��� ��¥���� ���� ��� �Լ� */
int calculateDateDifference(struct _calendar *cal) {
	int dateDifference = 0;

	/* �������� ��¥���� = (�⵵����->��¥����) + (������->��¥����) + (���̿��ִ������ǰ���) */
	dateDifference = calculateYearDifferenceToDate(cal) + calculateMonthDifferenceToDate(cal) + howManyLeapYear(cal);

	return dateDifference;
}

/* �Է¹��� �⵵�� 1����� �⵵���̸� ��¥���̷� �ٲ��ִ� �Լ� */
int calculateYearDifferenceToDate(struct _calendar *cal) {
	int yearDifferenceToDate = 0;

	yearDifferenceToDate = 365 * (cal->yearToPrint - FIRSTYEAR);	// ���Ⱑ 0���̾ƴ϶� 1���̹Ƿ� FIRSTYEAR�� ���ش�

	return yearDifferenceToDate;
}

/* �Է¹��� ������ 1������ �����̸� ��¥���̷� �ٲ��ִ� �Լ� */
int calculateMonthDifferenceToDate(struct _calendar *cal) {
	int MonthDifferenceToDate = 0;

	if (cal->monthToPrint == 1) {
		MonthDifferenceToDate = 0;
	}else if(cal->monthToPrint == 2){
		MonthDifferenceToDate = JANUARY;
	}else if (cal->monthToPrint == 3) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY);
	}else if (cal->monthToPrint == 4) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH);
	}else if (cal->monthToPrint == 5) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL);
	}else if (cal->monthToPrint == 6) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY);
	}else if (cal->monthToPrint == 7) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE);
	}else if (cal->monthToPrint == 8) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY);
	}else if (cal->monthToPrint == 9) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST);
	}else if (cal->monthToPrint == 10) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST + SEPTEMBER);
	}else if (cal->monthToPrint == 11) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST + SEPTEMBER + OCTOBER);
	}else if (cal->monthToPrint == 12) {
		MonthDifferenceToDate = (JANUARY + FEBRUARY + MARCH + APRIL + MAY + JUNE + JULY + AUGUST + SEPTEMBER + OCTOBER + NOVEMBER);
	}else {
		printf("calculateMonthDifferenceToDate Has ERROR!!!\n\n");
	}

	return MonthDifferenceToDate;
}

/* �ش� ��,���� 1���� ���� �������� ã�� �Լ� */
int findFistDay(struct _calendar *cal) {
	int DateDifference = 0;
	int whatDay = 0;
	/* ���� ���̳����� ������ִ� �Լ� */
	DateDifference = calculateDateDifference(cal);	// DateDifference���� 1�� 1�� 1�ϰ��� ��¥���̸�ŭ�� ���� ��

	/* �� */
	if ((DateDifference%7) == 0) {
		whatDay = MONDAY;
	}
	/* ȭ */
	else if ((DateDifference % 7) == 1){
		whatDay = TUESDAY;
	}
	/* �� */
	else if ((DateDifference % 7) == 2) {
		whatDay = WEDNESDAY;
	}
	/* �� */
	else if ((DateDifference % 7) == 3) {
		whatDay = THURSDAY;
	}
	/* �� */
	else if ((DateDifference % 7) == 4) {
		whatDay = FRIDAY;
	}
	/* �� */
	else if ((DateDifference % 7) == 5) {
		whatDay = SATURDAY;
	}
	/* �� */
	else if ((DateDifference % 7) == 6) {
		whatDay = SUNDAY;
	}
	else {
		printf("findFirstDay Has ERROR!!!");
	}

	return whatDay;
}

/* ���������� �޷��� ����ϴ� �Լ� */
void printCalendar(struct _calendar *cal) {
	int whatDay = 0;
	int presentDay = 0;
	int februaryLeapYear = 0;

	findHowManyDate(cal);
	whatDay = findFistDay(cal);

	/* ����Ϸ��� ���� 2���̰� �����̶�� */
	if ((cal->monthToPrint == 2)) {
		if (((cal->yearToPrint % 4 == 0) && (cal->yearToPrint % 100 != 0)) || (cal->yearToPrint % 400 == 0)) {
			februaryLeapYear++;
		}
	}
	 
	/* ������ ����Ϸ��� ���� 2���̰� �����̶�� februaryLeapYear==1�̹Ƿ� */
	/* +1�� �� ���̰�, �ƴ϶�� 0�̹Ƿ� �Ȱ��� �� */
	cal->howManyDate += februaryLeapYear;

	printf("\n\n");
	printf("\t%d�� %d�� CALENDAR\n\n",cal->yearToPrint,cal->monthToPrint);
	printf("\t��\t��\tȭ\t��\t��\t��\t��\n");

	
	/* for���� �ش� ����ŭ���鼭 */
	/* ����ϱ��� ��¥�� ��� ������ ���ش�. */
	/* i==0�϶��� ���� ���Ͽ� ���� \t�� ������ Ʋ�����Ƿ� �����ش� */
	
	if (whatDay == MONDAY) {
		presentDay = MONDAY;
		for (int i = 0; i <= (cal->howManyDate);i++) {
			/* ��ó�� */
			if (i==0) {
				printf("\t ");
			}
			else {
				printf("\t%d",i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == TUESDAY){
		presentDay = TUESDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* ��ó�� */
			if (i == 0) {
				printf("\t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == WEDNESDAY) {
		presentDay = WEDNESDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* ��ó�� */
			if (i == 0) {
				printf("\t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == THURSDAY) {
		presentDay = THURSDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* ��ó�� */
			if (i == 0) {
				printf("\t \t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == FRIDAY) {
		presentDay = FRIDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* ��ó�� */
			if (i == 0) {
				printf("\t \t \t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == SATURDAY) {
		presentDay = SATURDAY;
		for (int i = 0; i <= (cal->howManyDate); i++) {
			/* ��ó�� */
			if (i == 0) {
				printf("\t \t \t \t \t \t ");
			}
			else {
				printf("\t%d", i);

				if (presentDay == SATURDAY) {
					printf("\n");
					presentDay++;
				}
				else if (presentDay == SUNDAY) {
					presentDay = MONDAY;
				}
				else {
					presentDay++;
				}
			}
		}
	}
	else if (whatDay == SUNDAY) {
		presentDay = SUNDAY;
		for (int i = 1; i <= (cal->howManyDate); i++) {

			printf("\t%d", i);

			if (presentDay == SATURDAY) {
				printf("\n");
				presentDay++;
			}
			else if (presentDay == SUNDAY) {
				presentDay = MONDAY;
			}
			else {
				presentDay++;
			}
		}
	}

	return;
}

/* ������ �󸶳� �־����� ������ִ� �Լ� */
int howManyLeapYear(struct _calendar *cal) {
	int numOfLeapYear = 0;

	for (int i = 1; i <= (cal->yearToPrint);i++) {
		/* �������� */
		if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
			numOfLeapYear++;
		}
	}

	return numOfLeapYear;
}