#include "date.h"

struct _compareDate date;

void main() {
	inputDateUserWereBorn(&date);
	inputDateToCompare(&date);

	printf("## �¾ ��¥ : %d�� %d�� %d��\n", date.born_Year, date.born_Month, date.born_Date);
	printf("## ���� ��¥ : %d�� %d�� %d��\n", date.compare_Year, date.compare_Month, date.compare_Date);
	printf("## �� ��¥�� ���� : %d\n\n\n", calculateDifferenceDate(&date));

	return;
}

