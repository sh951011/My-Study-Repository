/*
2014707073 ���ȯ
9���� ����Ʈ����� �ǽ� �� ����
*/
#include "automobile.h"
#include <time.h>

/* �Լ����� ���� ���� include */

void main() {
	srand((unsigned)time(NULL));
	user_setting(&automobile_moving, &obs);
	system("cls");
	draw_map();
	draw_obstacle(&obs);
	obs_sorting(&obs);
	automobile_move(&automobile_moving, &automobile_coord, &obs);

	return;
}
