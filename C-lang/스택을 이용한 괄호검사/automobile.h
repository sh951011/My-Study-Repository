/*
2014707073 ���ȯ
2018�⵵ 1�б� 9���� ����Ʈ����� �ǽ� �� ����
*/

#include <stdio.h>
#include <windows.h>
#include <stdlib.h>
#include <conio.h>

#define random_column() rand()%3+1 // 1~3
#define random_coord() (rand()%30+1)*2 //  1~60
#define random_velocity() rand()%100+1
#define end_of_map 62
#define bottom_of_track 9
#define top_of_track 2
/*
�������� ��ֹ��� ������ ���̸� ���� #define random_column() rand()%3+1
�������� ��ֹ��� x��ǥ�� ���� #define random_coord() (rand()%30+1)*2
�������� �ڵ����� �ӵ��� �������ֱ� ���� Sleep�ȿ� �� ������ ���� #define random_velocity()
*/

/* ����ü ���� */

/* �ڵ����� �������� ������ Ű�� ���� �⸧ ����ü */
struct automobile_moving {
	char forward, up, down, backward;
	int oil;
	int velocity;
}automobile_moving;

/* �ڵ����� ��ǥ�� �������� ����ü */
struct automobile_coord {
	int x_coord;
	int y_coord;
}automobile_coord;

/* ��ֹ��� ���õ� �������� �������� ����ü */
struct obstacle {
	int coord[5];
	int num;
	int x_coord[10], y_coord[10];
}obstacle;

struct automobile_moving automobile_moving;
struct automobile_coord automobile_coord;
struct obstacle obs;

/* �Լ� ���� */
void gotoxy(int x, int y);
void user_setting(struct automobile_moving *automobile_moving, struct obstacle *obs); // �������� ���ð��� �Է¹޴� �Լ�
void draw_map(); // ���� �׷��ִ� �Լ�
void automobile_move(struct automobile_moving *automobile_moving, struct automobile_coord *automobile_coord, struct obstacle *obs); // �ڵ����� �������� �Լ�
void draw_obstacle(struct obstacle *obstacle); // ��ֹ��� �׷��� �Լ�
void obs_sorting(struct obstacle *obs); // ��ֹ� ��ǥ���� ũ������� �������ִ� �Լ�

/* �Լ� ���� */
void gotoxy(int x, int y) {
	COORD Pos;
	Pos.X = x;
	Pos.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

void user_setting(struct automobile_moving *automobile_moving, struct obstacle *obs) {
	int i = 0;

	printf("�÷��̾� ����\n");
	printf("�÷��̾� �Է� ���� Key : ");
	scanf_s(" %c", &automobile_moving->forward);

	printf("�÷��̾� �Է� up Key : ");
	scanf_s(" %c", &automobile_moving->up);

	printf("�÷��̾� �Է� down Key : ");
	scanf_s(" %c", &automobile_moving->down);

	printf("�÷��̾� �Է� backward Key : ");
	scanf_s(" %c", &automobile_moving->backward);

	printf("��ֹ� ���� �Է� : ");
	scanf_s(" %d", &obs->num);

	return;
}

void automobile_move(struct automobile_moving *automobile_moving, struct automobile_coord *automobile_coord, struct obstacle *obs) {
	char key;
	int obs_coord_num = 0;
	int i = 0;
	int oil_count = 0;
	int velocity = 0;
	////////////
	automobile_coord->x_coord = 0;
	automobile_coord->y_coord = 5;
	automobile_moving->oil = 10;
	// ó�� �ڵ����� ��ǥ�� (0,5)�� �������ְ�, ó�� �ڵ����� �⸧�� 10���� ����
	velocity = random_velocity();

	while (1) {
		///////////
		gotoxy(0, 11);
		printf("���� �⸧ : ");
		for (i = 0; i < automobile_moving->oil; i += 2) {
			gotoxy(i + 10, 11);
			printf("��");
		}
		gotoxy(automobile_moving->oil + 10, 11);
		printf("  ");
		///////////// ó������ �� 5���� �⸧���� �����ϴٰ� Ű ���� 10�� �Է¹��������� �ϳ��� �پ��� �Ѵ�.

		_kbhit(); // visual studio 2015 ������ _kbhit�� �̷��� ��
		key = _getch();
		oil_count++; // Ű�� �Է¹��������� oil_count�� ++�Ѵ�.
		if (oil_count == 10) {
			automobile_moving->oil = automobile_moving->oil - 2;
			oil_count = 0;
		}// Ű�� 10�� �Է¹��� ������ automobile_moving->oil�� 2�� �پ���
		//////
		if (automobile_moving->oil == 0) {
			system("cls");
			gotoxy(10, 10);
			printf("Ż�⿡ �����Ͽ����ϴ�!!!!");
			gotoxy(10, 11);
			system("pause");
			return;
		}
		///////// �ڵ����� �⸧�� 0�̵Ǹ� Ż���� �����ϰ� ������ ������

		/////////////
		if (automobile_coord->x_coord < obs->x_coord[0]) {
			obs_coord_num = 0;
		}
		for (i = 0; i < obs->num; i++) {
			if (automobile_coord->x_coord == obs->x_coord[i]) {
				obs_coord_num = i;
			}
		}
		for (i = 1; i < obs->num + 1; i++) {
			if (automobile_coord->x_coord < obs->x_coord[i] && automobile_coord->x_coord > obs->x_coord[i - 1]) {
				obs_coord_num = i;
			}
		}
		/////////////
		/*
		void obs_sorting(struct obstacle *obs) �Լ��� ��ֹ��� ��ǥ���� x��ǥ �������� ������������ ������ �س����Ƿ�,
		���� �ڵ����� ��ġ�� ���� obs_coord_num�� ���� �������ش�. obs_coord_num�� obs->x_coord[]�� obs->y_coord[]�� ���° �������� �˷��� ���̴�.
		�� obs->x_coord[obs_coord_num], obs->y_coord[obs_coord_num]�� �̿��Ͽ�, ��ֹ��� ������ �� �������� ���ϵ��� ó���Ѵ�.
							l							l						l						l
		obs_coord_num=0		l    obs_coord_num=1		l	obs_coord_num=2		l	obs_coord_num=3		l
							l							l						l						l
		��ֹ��� ��ġ		1(��ֹ�)					2						3						4 ... �̷���
		*/
		//////
		if (key == automobile_moving->backward) { // ���� �� �ڷ� �̵�
			if (automobile_coord->x_coord == 0) { // ���� ���϶��� ����ó��
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);  // �ڵ����� ��ǥ�� gotoxy�� �̵����ش�.
				Sleep(10 * velocity); // �������� ���ݾ� �����ֱ� ���� Sleep�� ��
				printf("��");
			}
			else if (automobile_coord->x_coord - 2 == obs->x_coord[obs_coord_num - 1] && automobile_coord->y_coord <= obs->y_coord[obs_coord_num - 1]) {
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("��");
			} // ��ֹ��� �������� �̵� ���ϵ��� ó��
			else {// ���� �ΰ��� ��츦 ������ ��� �ڷ� �̵�
				automobile_coord->x_coord = automobile_coord->x_coord - 2;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // �������� ���ݾ� �����ֱ� ���� Sleep�� ��
				printf("��");
				gotoxy(automobile_coord->x_coord + 2, automobile_coord->y_coord); // ������ �ִ�
				printf(" "); // ���� ������
			}
		}
		else if (key == automobile_moving->forward) { // ������ �� ������ �̵�
			///
			if (automobile_coord->x_coord + 2 == obs->x_coord[obs_coord_num] && automobile_coord->y_coord <= obs->y_coord[obs_coord_num]) {
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("��");
			}// ��ֹ��� �������� �̵� ���ϵ��� ó��

			///
			else {
				automobile_coord->x_coord = automobile_coord->x_coord + 2;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // �������� ���ݾ� �����ֱ� ���� Sleep�� ��
				printf("��");
				gotoxy(automobile_coord->x_coord - 2, automobile_coord->y_coord); // ������ �ִ�
				printf(" "); // ���� ������
			}
			if (automobile_coord->x_coord == end_of_map) { // ������ �¸��� ���� �ڵ����� ���� �ٴٸ��� �¸�
				system("cls");
				gotoxy(10, 10);
				printf("Ż�⿡ �����Ͽ����ϴ�!!!!");
				gotoxy(10, 11);
				system("pause");
				return;
			}
		}
		else if (key == automobile_moving->up) { // ���� �̵��ϴ� �Լ�
			if (automobile_coord->y_coord == top_of_track) { // Ʈ������ ���� ���� �ȵǹǷ� ����ó��
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("��");
			}
			else if (automobile_coord->x_coord == obs->x_coord[obs_coord_num] && automobile_coord->y_coord - 1 <= obs->y_coord[obs_coord_num]) {
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("��");
			}// ���� ��ֹ��� ���� �� �� �����̵��� ����
			else {
				automobile_coord->y_coord = automobile_coord->y_coord - 1;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity);
				printf("��");
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord + 1); // ������ �ִ�
				printf(" "); // ���� ������
			}// ���� �� ��츦 �����ϰ�� ���� �̵��ϵ��� ����
		}
		else if (key == automobile_moving->down) { // ������ �̵�
			if (automobile_coord->y_coord == bottom_of_track) { // Ʈ������ ������ ���� �ȵǹǷ� ����ó��
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // �������� ���ݾ� �����ֱ� ���� Sleep�� ��
				printf("��");
			}
			else {
				automobile_coord->y_coord = automobile_coord->y_coord + 1;
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord);
				Sleep(10 * velocity); // �������� ���ݾ� �����ֱ� ���� Sleep�� ��
				printf("��");
				gotoxy(automobile_coord->x_coord, automobile_coord->y_coord - 1); // ������ �ִ�
				printf(" "); // ���� ������
			}
		}
	}
	return;
}

void draw_map() { // Ʈ���� �׷��ִ� �Լ�
	int i = 0;

	for (i = 0; i <= end_of_map; i += 2) {
		gotoxy(i, 1);
		printf("��");
	}

	for (i = 0; i <= end_of_map; i += 2) {
		gotoxy(i, 10);
		printf("��");
	}
}

void draw_obstacle(struct obstacle *obs) { // ��ֹ��� �������� �׷��ִ� �Լ�
	int i = 0, j = 0;
	int column = 0, coord = 0;

	for (j = 0; j < obs->num; j++) {
		obs->x_coord[j] = 0;
		obs->y_coord[j] = 0;
	} // obs ���� �ʱ�ȭ


	for (j = 0; j < obs->num; j++) {
		column = random_column() + 1; // ��ֹ� ���� ��ǥ�� 2~4�� �������� ����
		coord = random_coord(); // ��ֹ� x ��ǥ�� 1~60���� �������� �������� ���� 

		for (i = 2; i <= column; i++) {
			gotoxy(coord, i);
			printf("��");
		}
		/*
		��, �������� ���� coord�� �̿���
		(coord,2~column)���� ��ֹ��� ������
		*/
		obs->x_coord[j] = coord;
		obs->y_coord[j] = column;

		for (i = j; i > 0; i--) {
			if (coord == obs->x_coord[i - 1]) {
				j--;
			}
		}		// coord���� ��ĥ ��츦 �����Ͽ� ���� ���� coord���� �� ���� coord���� ������ j�� �ϳ� �ٿ������ν� �ٽ� �ݺ��Ѵ�.
	}
}

void obs_sorting(struct obstacle *obs) { // obs->x_coord[j],obs->y_coord[j]�� ������������ ���� (�ڵ�¥�µ� ���Ǹ� ����)
	int i = 0, j = 0;
	int buffer_x = 0, buffer_y = 0;

	for (i = 0; i < obs->num - 1; i++) {
		for (j = 0; j < obs->num - 1; j++) {
			if (obs->x_coord[j] > obs->x_coord[j + 1]) {
				buffer_x = obs->x_coord[j];
				obs->x_coord[j] = obs->x_coord[j + 1];
				obs->x_coord[j + 1] = buffer_x;

				buffer_y = obs->y_coord[j];
				obs->y_coord[j] = obs->y_coord[j + 1];
				obs->y_coord[j + 1] = buffer_y;
			}
		}
	}
	/*
	������������ sorting�Ѵ�
	*/
	return;
}
