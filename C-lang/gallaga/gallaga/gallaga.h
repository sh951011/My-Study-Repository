/*

## 2018�� 2�г� 1�б� ����Ʈ����� ������Ʈ
## ������б� ������Ű��а�
## 2014707073 ���ȯ
## c���� �����غ� ������

*/
#include <stdio.h>
#include <conio.h>
#include <windows.h>
#include <stdlib.h>
#include <time.h>
#include <process.h>

/* Define */
#define TRUE 1							// ��  (���� �����̸��� ����Ǵ� ���)
#define FALSE 0							// ����(���� �����̸��� ������� �ʴ� ���)
#define random() (float)rand()/RAND_MAX	// 0~1 ������ ���� �߻��� ���� define
#define LEFT 75							// ���� ����Ű ASCII CODE define
#define RIGHT 77						// ������ ����Ű ASCII CODE define
#define SPACE 32						// SPACE Ű ASCII CODE define
#define PAUSE 112						// p Ű ASCII CODE define ( ���� �Ͻ����� )
#define CHEATKEY 97						// a Ű ASCII CODE define ( ���� ���� Ȯ���� ���� �������� �ѱ�� �� Ŭ��� ���� )
#define ESC 27							// ESC ASCII CODE define ( ���� ������ )
#define user_y_end 23					// STAGE1 USER Y��ǥ
#define user_y_start 1					// STAGE1 Y��ǥ ���۰� ( �� Y : 1~23�� ����ȭ�� )
#define user_x_start 1					// STAGE1 X��ǥ ���۰� 
#define user_x_end 55					// STAGE1 X��ǥ ���� ( �� X : 1~55�� ����ȭ�� )
#define user_x_center 27				// STAGE1 X��ǥ ����
#define user_y_center 11				// STAGE1 Y��ǥ ����
#define move_x 1						// x�� �����̴� ��ŭ define ( ������ ���Ǹ� ���� )
#define missile_velocity 20				// �̻��� �ӵ��� �������� �� Sleep�� parameter�� �� �� Ŭ���� ������
#define BOSSMODE_Y_END 33				// BOSS STAGE Y �� ��
#define BOSSMODE_Y_CENTER 16			// BOSS STAGE Y ����
#define time_x 65						// Map Draw�� ���� define
#define time_y 3						// Map Draw�� ���� define
#define easy_mode_menu 60				// Map Draw�� ���� define
#define puts_easymode_y 1				// Map Draw�� ���� define
#define puts_time_y 3					// Map Draw�� ���� define
#define puts_besttime_y 5				// Map Draw�� ���� define
#define puts_life_y 9					// Map Draw�� ���� define
#define puts_life_x 65					// Map Draw�� ���� define
#define puts_item_y 11					// Map Draw�� ���� define
#define puts_SPACE_y 15					// Map Draw�� ���� define
#define puts_M_y 16						// Map Draw�� ���� define
#define puts_P_y 17						// Map Draw�� ���� define
#define puts_ESC_y 18					// Map Draw�� ���� define
#define PUTS_BOSSMODE_MENU 3			// Map Draw�� ���� define
#define PUTS_BOSSMODE_TIME 5			// Map Draw�� ���� define
#define PUTS_BOSSMODE_BESTTIME 7		// Map Draw�� ���� define
#define PUTS_BOSSMODE_LIFE 13			// Map Draw�� ���� define
#define PUTS_BOSSMODE_ITEM 16			// Map Draw�� ���� define
#define PUTS_BOSSMODE_SPACE 22			// Map Draw�� ���� define
#define PUTS_BOSSMODE_M 24				// Map Draw�� ���� define
#define PUTS_BOSSMODE_P 26				// Map Draw�� ���� define
#define PUTS_BOSSMODE_ESC 28			// Map Draw�� ���� define
#define BOSSMODE_Y_END 33				// BOSS STAGE Y ����
#define item1_x_end 45					// ù��° ������ �����̴� ������ ����
#define item1_x_start 10				// ù��° ������ �����̴� ������ ���۰�
#define item2_3_x_end 55				// �ι�° ������ �����̴� ������ ����
#define item2_3_x_start 1				// �ι�° ������ �����̴� ������ ���۰�
#define Beginning_Life 3				// User Life�� 3���� ����
#define End_Life 0						// Life�� 0 �Ǹ� ������ �ϱ� ����
#define Item_Velocity 2					// Item�� �ӵ� ���� Sleep paramer
#define SOL   1567.982					// Beep�Լ��� �̻��� �߻�ø��� ���� ȿ���� (��)
#define TIME 100						// Beep�Լ��� �� ���ӽð�
/* Define */

/* �Լ� ���� */
void gotoxy(int x, int y);							// gotoxy�Լ� ����
char Menu();										// ���ӽ��� �޴�ȭ��
char Game_Start();									// 1. ���ӽ��� ���ý� ����Ǵ� ȭ��
void Time_Count();									// ����ð��� count���ִ� �Լ�
void Map_Draw_Stage1(struct gallaga *gal);			// Stage1 Map Draw �Լ�
void OBSTACLE_COORD(struct gallaga *gal);			// Stage1�� ��ֹ����� ��ǥ�� �����ϴ� �Լ�
void EASY_MODE_STAGE1_CLEAR(struct gallaga *gal);	// Stage1(Easy)���� ��ֹ����� ���� �� Ŭ��� ����ϴ� �Լ�
void Draw_Life(struct gallaga *gal);				// Life�� ���� �� ���ҿ� ���� Lifeǥ�ø� ���ִ� �Լ�
void Minus_Life(struct gallaga *gal);				// User�� ��ǻ���� ���ݿ� ���� �� Life Minus�� ���ִ� �Լ�
void EASY_MODE_STAGE1(struct gallaga *gal);			// Easy Mode ����ȭ�鿡 �ش��ϴ� �Լ�(�����Լ�) ���� �Լ����� ���⼭ ����ȴ�
void MAP_DRAW_BOSSSTAGE();							// BOSS STAGE Map Draw �Լ�
void FAIL();										// FAIL�� ������ �������� ǥ�����ִ� �Լ�
void ITEM_ACT(struct gallaga *gal);					// ITEM�� �ߵ��ϴ� �Լ�
void MAP_DRAW_HARD_STAGE1();						// BOSS STAGE Map Draw(Hard) �Լ�
void Time_Count_BOSSSTAGE(struct gallaga *gal);		// Boss STAGE �ð� count �Լ�
void Draw_Life_BOSSSTAGE(struct gallaga *gal);		// Boss STAGE Life�� �׸��� �Լ�
void Minus_Life_BOSSSTAGE(struct gallaga *gal);		// Minus Life (Boss Stage)
void BOSSSTAGE_START(struct gallaga *gal);			// BOSS STAGE ���۽� ����Ǵ� �Լ� (�⺻���� ������ ����)
int BOSS_CLEAR(struct gallaga *gal);				// BOSS CLEAR�� 1�� ��ȯ���ִ� �Լ�
void BOSSSTAGE(struct gallaga *gal);				// BOSS STAGE ����ȭ�鿡 �ش��ϴ� �Լ�(�����Լ�) ���� �Լ����� ���⼭ ����ȴ�
void BOSS_MOVE(struct gallaga *gal);				// BOSS�� �¿�� ��� �Դٰ��� �ϰ� ���ִ� �Լ����� BOSS ��ų�� ����Ǵ� �Լ����� BOSS ���򺯰�
void SKILL_TIME(struct gallaga *gal);				// 10�ʰ� ���� �Ŀ� SKILL�� �������ִ� �Լ�
void BOSSSTAGE_HARD(struct gallaga *gal);			// BOSS STAGE HARD�� �ش��ϴ� �Լ�
void HOW_PLAY();									// ���ӹ���� �����ִ� �Լ�
void HARD_MODE_STAGE1(struct gallaga *gal);			// STAGE1H(HARD)�� �ش��ϴ� �Լ�
void RANKING_EASY(struct gallaga *gal);				// EASY CLEAR�� RANKING�� �ű�� �Լ�
void SHOW_RANKING_EASY(struct gallaga *gal);		// EASY RANKING�� �����ִ� �Լ�
void RANKING_HARD(struct gallaga *gal);				// HARD CLEAR�� RANKING�� �ű�� �Լ�
void SHOW_RANKING_HARD(struct gallaga *gal);		// HARD RANKING�� �����ִ� �Լ�
char select_rank();									// USER�� EASY�� HARD ��ŷ�� ��� ���� ���� ���� �Լ�
void Game_Option(struct gallaga *gal);				// ���Ӽӵ� ������ ���� ���ӿɼǿ� �ش��ϴ� �Լ�
void start();										// ���� ���ӽ� ����Ǵ� ȭ��
void variable_initiate(struct gallaga *gal);		// ����ü ���� �ʱ�ȭ���ִ� �Լ�
/* �Լ� ���� */


/* �ð� ��꿡 ���Ǵ� ������ */
time_t s1, s2, s3, s4, s5;

/* ����ü ���� */
struct gallaga {
	int item1_x, item2_x, item3_x, item1_go, item2_go, item3_go;
	int flight_x;
	int missile, missile_x, missile_y;
	int computer_attack_x_coord[30];
	int Life, Game_End;
	int EASYMODE_obs_x[3][14];
	int EASYMODE_obs_y[3];
	int CLEAR_CONDITION[14];
	int missile_stop;
	int EASYMODE_STAGE1_CLEAR;
	int CLEAR_CONDITION_SUM;
	int missile_distinguish;
	int BOSS_missile_y;
	float attack_number;
	int flag, for_flag;
	int BOSS_COORD_X1, BOSS_COORD_X2;
	int BOSS_HP;
	int ITEM1, ITEM2, ITEM3;
	int KEY_CONTRARY, ATTACK_NUMBER_PLUS;
	int FOR_TIME;
	int overlap;
	int STAGE1_TIME;
	int TOTAL_TIME;
	char ID_EASY[10][20];
	int USER_NUM_EASY;
	int USER_TIME_EASY[10];
	int USER_RANKING_EASY[10];
	char ID_HARD[10][20];
	int USER_NUM_HARD;
	int USER_TIME_HARD[10];
	int USER_RANKING_HARD[10];
	int GAME_SPEED;
};
/* ����ü ���� */

struct gallaga gal;

/* �Լ� ���� */
void gotoxy(int x, int y) {
	COORD Pos;
	Pos.X = x;
	Pos.Y = y;
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), Pos);
}

void variable_initiate(struct gallaga *gal) {
	gal->USER_NUM_EASY = 0;
	gal->USER_NUM_HARD = 0;
	gal->GAME_SPEED = 0;
	for (int j = 0; j < 10; j++) {
		for (int i = 0; i < 20; i++) {
			gal->ID_EASY[j][i] = '0';
			gal->ID_HARD[j][i] = '0';
		}
	}
}

void Map_Draw_Stage1(struct gallaga *gal) {
	int i = 0;
	int buffer = 0, sec = 0, minute = 0;

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	gotoxy(easy_mode_menu, puts_easymode_y);
	puts("Easy Mode");
	gotoxy(easy_mode_menu, puts_time_y);
	puts("time : ");
	gotoxy(easy_mode_menu, puts_life_y);
	puts("Life : ");
	gotoxy(easy_mode_menu, puts_item_y);
	puts("Item : ");
	gotoxy(easy_mode_menu, puts_SPACE_y);
	puts("SPACE : Launch");
	gotoxy(easy_mode_menu, puts_M_y);
	puts("M : Item use");
	gotoxy(easy_mode_menu, puts_P_y);
	puts("P : Pause");
	gotoxy(easy_mode_menu, puts_ESC_y);
	puts("ESC : Quit");

	for (i = 0; i < user_y_end + 1; i++) {
		gotoxy(57, i); puts("��");
	}

	gotoxy(57, 7);
	printf("����������������������");

	gotoxy(57, 13);
	printf("����������������������");

	gotoxy(3, 2);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("�� ��   �� ��   �� ��   �� ��   �� ��   �� ��   �� ��"); //x��ǥ 1 4  9 12  17 20  25 28  33 36  41 44  49 52
	gotoxy(3, 4);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	puts("�� ��   �� ��   �� ��   �� ��   �� ��   �� ��   �� ��"); //55,4
	gotoxy(3, 6);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("�� ��   �� ��   �� ��   �� ��   �� ��   �� ��   �� ��"); //55,2
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	return;
}

void start() {
	for (int i = 0; i < 20; i++) {
		Sleep(200);
		if (i % 2) {
			gotoxy(1, 1);
			puts("");
			puts("     ����            ");
			puts("   ��      ��       �� �� ");
			puts("   ��                �� ��                    ");
			puts("   ��                �� ��              ");
			puts("   ��    ���  ���  �� ��   ���    ���   ���         ");
			puts("   ��      �� ��  ��  �� �� ��  ��  ��  �� ��  ��");
			puts("     ����    ����  �� �� ����  ���   ����  ");
			puts("                                        �� ");
			puts("                                     ��� ");
		}
		else {
			gotoxy(1, 1);
			puts("");
			puts("     ����            ");
			puts("   ��      ��       �� �� ");
			puts("   ��                �� ��                    ");
			puts("   ��                �� ��              ");
			puts("   ��    ���  ���  �� ��   ���    ���   ���         ");
			puts("   ��      �� ��  ��  �� �� ��  ��  ��  �� ��  ��");
			puts("     ����    ����  �� �� ����  ���   ����  ");
			puts("                                        �� ");
			puts("                                     ��� ");
		}
	}
	system("cls");

	return;
}

char Menu() {
	char menu_select;

	puts("");
	puts("     ����            ");
	puts("   ��      ��       �� ��                             �Ȧ� �� �� �� �� �� �� ����");
	puts("   ��                �� ��                            ��  1. ���ӽ���          ��");
	puts("   ��                �� ��                            ���� �� �� �� �� �� �� ����");
	puts("   ��    ���  ���  �� ��   ���    ���   ���      ��  2. ��ŷȮ��          ��");
	puts("   ��      �� ��  ��  �� �� ��  ��  ��  �� ��  ��     ���� �� �� �� �� �� �� ����");
	puts("     ����    ����  �� �� ����  ���   ����    ��  3. ���ӿɼ�          ��");
	puts("                                        ��            ���� �� �� �� �� �� �� ����");
	puts("                                     ���             ��  4. ��������          ��");
	puts("                                                      �Ŧ� �� �� �� �� �� �� ���� \n");
	puts("                                    KwangWoon University ����Ʈ����� ������Ʈ");
	puts("                                                               2014707073 ���ȯ");

	do {
		menu_select = _getch();
	} while (menu_select<'1' || menu_select>'4');
	system("cls");

	return menu_select;
}

char Game_Start() {
	char select_mode = '0';


	puts("");
	puts("     ����            ");
	puts("   ��      ��       �� ��                             �Ȧ� �� �� �� �� �� �� ����");
	puts("   ��                �� ��                            ��  1. EASY MODE         ��");
	puts("   ��                �� ��                            ���� �� �� �� �� �� �� ����");
	puts("   ��    ���  ���  �� ��   ���    ���   ���      ��  2. HARD MODE         ��");
	puts("   ��      �� ��  ��  �� �� ��  ��  ��  �� ��  ��     ���� �� �� �� �� �� �� ����");
	puts("     ����    ����  �� �� ����  ���   ����    ��  3. ���ӹ��          ��");
	puts("                                        ��            �Ŧ� �� �� �� �� �� �� ����");
	puts("                                     ��� ");
	puts("\n");
	puts("                                    KwangWoon University ����Ʈ����� ������Ʈ");
	puts("                                                               2014707073 ���ȯ");

	do {
		select_mode = _getch();
	} while (select_mode<'1' || select_mode>'3');
	//return select_mode;
	system("cls");

	return select_mode;
}

/* easy mode stage 1�� �ش��ϴ� �Լ� */
void EASY_MODE_STAGE1(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0;
	int x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;


	/* ����ü �������� �ʱ�ȭ */
	for (i = 0; i < 14; i++) {
		gal->CLEAR_CONDITION[i] = 0;
	}
	gal->missile_distinguish = 0;
	gal->flight_x = 27;
	gal->missile = 0;
	gal->item1_x = 10;
	gal->item2_x = 55;
	gal->item3_x = 1;
	gal->item1_go = 1;
	gal->item2_go = 1;
	gal->item3_go = 1;
	gal->Life = 3;
	gal->Game_End = 0;
	gal->EASYMODE_STAGE1_CLEAR = 0;
	gal->missile_stop = 0;
	gal->ITEM1 = 1;
	gal->ITEM2 = 1;
	gal->ITEM3 = 1;
	gal->attack_number = 0.2;
	/* ����ü �������� �ʱ�ȭ */
	Map_Draw_Stage1(gal);
	OBSTACLE_COORD(gal);

	/* ���� ���� �� time count ���� ���� */
	gotoxy(gal->flight_x, user_y_end);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("��");
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	gotoxy(user_x_center, user_y_center);
	puts("READY !!");
	Sleep(3000);
	gotoxy(user_x_center, user_y_center);
	puts("START !!");
	Sleep(500);
	gotoxy(user_x_center, user_y_center);
	puts("        ");
	time(&s1);
	/* ���� ���� �� time count ���� ���� */


	while (1) {	// while �� ����
		Time_Count();
		Draw_Life(gal);
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob < gal->attack_number) { // Ȯ���� �� ���� ������ �����ϴ� �� (#define attack_number �������� ���� ���� ����)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 ��ǥ���� �������� ��ǥ�� ��´�

														/* ó�� �����Ҷ� ����ó�� */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */

		/* ũ�� for�� 2���� ������ ������, ��ǻ���� ����, �̻��� �߻�, Ű �Է��� ���� �������� ���� */
		for (i = 8; i < 16; i++) {	// 1�� for��
			Time_Count();
			gotoxy(12, 12); printf("                         ");
			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return 1;
			}

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* ���� Ű �Է��� �޴´ٸ� �Ʒ��� if���� �����Ѵ� */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* ����Ű ���� ���� int���� ������ �Ѿ�� ������ �ι��� ��������� �Ѵ� */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // ���� �ִ� ���� �����
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // �����ִ� ���� �����
							printf(" ");
							break;
						}
					default:
						break;
					}
				}

				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;

					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;

					case ESC:
						return;
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			}

			/* Ű �Է��� ���ٸ� �Ʒ��� else���� �����Ѵ� */
			else {
				Time_Count();

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* ������ �����̴� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x++;
					}
					if (gal->ITEM2) {
						gal->item2_x--;
					}
					if (gal->ITEM3) {
						gal->item3_x++;
					}
				}
				/*1,3�� �����۰� 2�� �������� ������ �ݴ�� �����δ�*/

				/* gal->missile_distinguish�� �̻����� �߻� ���϶� �� �̻����� �߻� ���ϰ� �ϴ� �����̴� */
				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
								EASY_MODE_STAGE1_CLEAR(gal);
							}
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						ITEM_ACT(gal);

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (gal->EASYMODE_STAGE1_CLEAR) {
							system("cls");
							gotoxy(25, 10);
							printf("***CLEAR***");
							time(&s2);
							gal->STAGE1_TIME = difftime(s2, s1);
							system("pause");
							return;
						}

					}
				}
				/* �̻��� �߻� �κ� �� */

				/*���� ��ǻ�� ���� �κ� ����*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 8);
					printf("I");
					gotoxy(attack_x[1][j], i + 7);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 15) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[1][k], user_y_end);
						printf(" ");
					}
				}
				if (i == 15) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1�� for�� ����

		for (i = 16; i < 24; i++) {	// 2�� for�� ����
			Time_Count();
			gotoxy(12, 12); printf("                         ");

			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return;
			}

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* Ű �Է��� �޴´ٸ� if �� ���� */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // ���� �ִ� ���� �����
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // �����ִ� ���� �����
							printf(" ");
							break;
						}
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case ESC:
						return;
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			} // Ű �Է��� ��� ��

			  /*Ű �Է��� ���� ���*/
			else {
				Time_Count();

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* ������ �����̴� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x--;
					}
					if (gal->ITEM2) {
						gal->item2_x++;
					}
					if (gal->ITEM3) {
						gal->item3_x--;
					}
				}
				/* ������ �����̴� �κ� �� */

				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
							EASY_MODE_STAGE1_CLEAR(gal);
						}
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					ITEM_ACT(gal);

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (gal->EASYMODE_STAGE1_CLEAR) {
						system("cls");
						gotoxy(25, 10);
						printf("***CLEAR***");
						time(&s2);
						gal->STAGE1_TIME = difftime(s2, s1);
						system("pause");
						return;
					}
				}


				/* �̻��� �߻� �κ� �� */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ���� ��ǻ�� ���� �κ� ���� */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I���� ��ǥ�� gal ����ü�� �Ѱ��ش� */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *���� ��ǥ�� gal ����ü�� �Ѱ��ش�
				}
				if (i == user_y_end) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[0][k], user_y_end);
						printf(" ");
					}
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 8);
					printf("I");
					gotoxy(attack_x[1][j], i - 9);
					printf("  ");
				}
				if (i == user_y_end) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2�� for�� ����

	}// while�� ����	
	return;
}

/*����ð��� �˷��ִ� �Լ�*/
void Time_Count() {
	int minute = 0, sec = 0;
	int buffer = 0;

	time(&s2);

	buffer = difftime(s2, s1);
	minute = buffer / 60;
	sec = buffer % 60;
	if (buffer < 60) {
		gotoxy(time_x, time_y);
		printf("%d��", sec);
	}

	else {
		gotoxy(time_x, time_y);
		printf("     ");
		gotoxy(time_x, time_y);
		printf("%d��%d��", minute, sec);
	}



	return;
}

/* �� ���ݿ� ������ Life�� �پ��� �ϴ� �Լ� */
void Minus_Life(struct gallaga *gal) {
	int i = 0;
	int protect_overlap = 0;

	for (i = 0; i < 25; i++) {
		/* ( ��ǻ�� ���� ��ǥ-1 ) <= ����� ��ǥ >= ( ��ǻ�� ���� ��ǥ+1 ) �̸� Life�� �پ��� */
		if (gal->computer_attack_x_coord[i] == gal->flight_x
			|| gal->computer_attack_x_coord[i] + 1 == gal->flight_x)
		{
			if (protect_overlap == FALSE) {
				protect_overlap = TRUE;
				gal->Life--;
				gotoxy(gal->flight_x, user_y_end);
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
				printf("��");
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
			}
		}
	}

	/* �������� 0�� �Ǹ� ������ ������ ���� �� */
	if (gal->Life <= End_Life) {
		gal->Game_End = TRUE;
	}

	return;
}

/* ���� Life�� ��Ȳ�� �׷��ִ� �Լ� */
void Draw_Life(struct gallaga *gal) {
	int i = 0;
	for (i = 0; i < gal->Life; i++) {
		gotoxy(puts_life_x + 2 * i, puts_life_y);
		printf("��");
	}
	gotoxy(puts_life_x + 2 * i, puts_life_y);
	printf("  ");

	return;
}

/* EASYMODE STAGE1�� ��ֹ����� ��ǥ�� �����ϴ� �Լ� */
void OBSTACLE_COORD(struct gallaga *gal) {
	int i = 0;

	for (i = 0; i < 3; i++) {
		gal->EASYMODE_obs_x[i][0] = 2;
		gal->EASYMODE_obs_x[i][1] = 5;
		gal->EASYMODE_obs_x[i][2] = 10;
		gal->EASYMODE_obs_x[i][3] = 13;
		gal->EASYMODE_obs_x[i][4] = 18;
		gal->EASYMODE_obs_x[i][5] = 21;
		gal->EASYMODE_obs_x[i][6] = 26;
		gal->EASYMODE_obs_x[i][7] = 29;
		gal->EASYMODE_obs_x[i][8] = 34;
		gal->EASYMODE_obs_x[i][9] = 37;
		gal->EASYMODE_obs_x[i][10] = 42;
		gal->EASYMODE_obs_x[i][11] = 45;
		gal->EASYMODE_obs_x[i][12] = 50;
		gal->EASYMODE_obs_x[i][13] = 53;
	}
	gal->EASYMODE_obs_y[0] = 5;
	gal->EASYMODE_obs_y[1] = 3;
	gal->EASYMODE_obs_y[2] = 1;

	return;
}

/* ���������� Ŭ���� �ϱ� ���� ���� �Լ� */
void EASY_MODE_STAGE1_CLEAR(struct gallaga *gal) {
	int i = 0;

	for (i = 0; i < 14; i++) {
		/* �̻����� ��ǥ�� ��ֹ� ��ǥ���� +2������ ������ �ִٸ� ���� */
		if (gal->missile_x == gal->EASYMODE_obs_x[0][i] || gal->missile_x == gal->EASYMODE_obs_x[0][i] + 1
			|| gal->missile_x == gal->EASYMODE_obs_x[0][i] + 2)
		{
			/* �̻����� ù°�ٿ� ������ �� ��, CLEAR_CONDITION[i]�� ���� �̻����� �����Ѵ� */
			/* ��, 0�϶��� ù°�� ����, ù°���� ���ݴٸ� ���� 1�� ���� �ι�° �ٱ��� ���� ���� �����ϰ�, */
			/* �� �������� �ι�° �� ������ �� �� �ְ�, �ι�° �ٿ� ���� CLEAR_CONDITION[i]���� 2�� �Ǿ� 3��° �ٱ��� �� �� �ִ� */
			if (gal->missile_y == gal->EASYMODE_obs_y[0] && gal->CLEAR_CONDITION[i] == 0) {
				gal->missile_stop = 1;
				gotoxy(gal->missile_x, gal->missile_y);
				printf("  ");
				gotoxy(gal->missile_x, gal->missile_y + 1);
				printf("  ");
				gal->CLEAR_CONDITION[i] = 1;
			}
			if (gal->missile_y == gal->EASYMODE_obs_y[1] && gal->CLEAR_CONDITION[i] == 1) {
				gal->missile_stop = 1;
				gotoxy(gal->missile_x, gal->missile_y);
				printf("  ");
				gotoxy(gal->missile_x, gal->missile_y + 1);
				printf("  ");
				gal->CLEAR_CONDITION[i] = 2;
			}
			if (gal->missile_y == gal->EASYMODE_obs_y[2] && gal->CLEAR_CONDITION[i] == 2) {
				gal->missile_stop = 1;
				gotoxy(gal->missile_x, gal->missile_y);
				printf("  ");
				gotoxy(gal->missile_x, gal->missile_y + 1);
				printf("  ");
				gal->CLEAR_CONDITION[i] = 3;
			}
		}
	}
	gal->CLEAR_CONDITION_SUM = 0;
	for (i = 0; i < 14; i++) {
		gal->CLEAR_CONDITION_SUM += gal->CLEAR_CONDITION[i];
	}

	/* ���� Ŭ���� ���� */
	/* ���� �� �μ��� ���ؼ���gal->CLEAR_CONDITION[i]�� ���� 42�� �Ǿ� �ϹǷ�  */
	if (gal->CLEAR_CONDITION_SUM == 42) {
		gal->EASYMODE_STAGE1_CLEAR = TRUE;
	}

	return;
}

void MAP_DRAW_BOSSSTAGE() {
	int i = 0;

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_MENU);
	puts("BOSS STAGE");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_TIME);
	puts("time : ");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_LIFE);
	puts("Life : ");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_ITEM);
	puts("Item : ");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_SPACE);
	puts("SPACE : Launch");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_M);
	puts("M : Item use");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_P);
	puts("P : Pause");
	gotoxy(easy_mode_menu, PUTS_BOSSMODE_ESC);
	puts("ESC : Quit");

	for (i = 0; i < BOSSMODE_Y_END + 1; i++) {
		gotoxy(57, i); puts("��");
	}

	gotoxy(57, 11);
	printf("����������������������");

	gotoxy(57, 19);
	printf("����������������������");

	return;
}

void Draw_Life_BOSSSTAGE(struct gallaga *gal) {
	int i = 0;

	for (i = 0; i < gal->Life; i++) {
		gotoxy(puts_life_x + 2 * i, PUTS_BOSSMODE_LIFE);
		printf("��");
	}
	gotoxy(puts_life_x + 2 * i, PUTS_BOSSMODE_LIFE);
	printf("  ");

	return;
}

void Time_Count_BOSSSTAGE(struct gallaga *gal) {
	int minute = 0, sec = 0;
	int buffer = 0;

	time(&s2);
	buffer = difftime(s2, s1) + gal->STAGE1_TIME;
	minute = buffer / 60;
	sec = buffer % 60;
	if (buffer < 60) {
		gotoxy(time_x, PUTS_BOSSMODE_TIME);
		printf("%d��", sec);
	}

	else {
		gotoxy(time_x, PUTS_BOSSMODE_TIME);
		printf("     ");
		gotoxy(time_x, PUTS_BOSSMODE_TIME);
		printf("%d��%d��", minute, sec);
	}
	return;
}

void Minus_Life_BOSSSTAGE(struct gallaga *gal) {
	int i = 0;
	int protect_overlap = 0;

	for (i = 0; i < 25; i++) {
		/* ( ��ǻ�� ���� ��ǥ-1 ) <= ����� ��ǥ >= ( ��ǻ�� ���� ��ǥ+1 ) �̸� Life�� �پ��� */
		if (gal->computer_attack_x_coord[i] == gal->flight_x
			|| gal->computer_attack_x_coord[i] + 1 == gal->flight_x)
		{
			if (protect_overlap == FALSE) {
				protect_overlap = TRUE;
				gal->Life--;
				gotoxy(gal->flight_x, BOSSMODE_Y_END);
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
				printf("��");
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
			}
		}
	}

	/* �������� 0�� �Ǹ� ������ ������ ���� �� */
	if (gal->Life <= End_Life) {
		gal->Game_End = TRUE;
	}

	return;
}

void BOSSSTAGE_START(struct gallaga *gal) {
	gotoxy(gal->flight_x, BOSSMODE_Y_END);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("��");
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	gotoxy(user_x_center, BOSSMODE_Y_CENTER);
	puts("READY !!");
	Sleep(3000);
	gotoxy(user_x_center, BOSSMODE_Y_CENTER);
	puts("START !!");
	Sleep(500);
	gotoxy(user_x_center, BOSSMODE_Y_CENTER);
	puts("        ");
	time(&s1);

	return;
}

void FAIL() {
	system("cls");
	gotoxy(20, 5);
	printf("��������    ��������\n");
	gotoxy(20, 6);
	printf("      ��                ��\n");
	gotoxy(20, 7);
	printf("      ��                ��\n");
	gotoxy(20, 8);
	printf("      ��                ��\n");
	gotoxy(20, 9);
	printf("      ��                ��\n");
	gotoxy(20, 10);
	printf("      ��       ��       ��              ���� ��ȸ��...\n");
	gotoxy(20, 1);
	system("pause");

	return;
}

int BOSS_CLEAR(struct gallaga *gal) {
	int CLEAR = 0;

	if (gal->missile_x >= gal->BOSS_COORD_X1 && gal->missile_x <= gal->BOSS_COORD_X2 && gal->missile_y == 15) {
		gal->missile_stop = TRUE;
		gal->BOSS_HP--;
		gotoxy(gal->missile_x, 15); printf(" ");
	}

	if (gal->BOSS_HP <= 0) {
		CLEAR = 1;
	}


	return CLEAR;
}

void ITEM_ACT(struct gallaga *gal) {
	float prob = 0;

	if ((gal->item1_x == gal->missile_x || gal->item1_x == gal->missile_x - 1) && gal->missile_y == 1) {
		gal->ITEM1 = 0;
		gotoxy(gal->item1_x, 1); printf("  ");
		gal->item1_x = 60;

		prob = random();
		if (prob < 0.45) {
			gal->Life++;
			gotoxy(12, 12); printf("�������� ������ϴ�!!");
		}
		else if (prob > 0.45 && prob < 0.9) {
			gotoxy(puts_life_x, puts_item_y); printf("��");
			gotoxy(12, 12); printf("�� ��ų�� ������ϴ�!!");
		}
		else if (prob > 0.9 && prob < 1) {
			gal->CLEAR_CONDITION_SUM = 42;
		}
	}
	if ((gal->item2_x == gal->missile_x || gal->item2_x == gal->missile_x - 1) && gal->missile_y == 3) {
		gal->ITEM2 = 0;
		gotoxy(gal->item2_x, 3); printf("  ");
		gal->item2_x = 60;
		prob = random();
		if (prob < 0.45) {
			gal->Life++;
			gotoxy(12, 12); printf("�������� ������ϴ�!!");
		}
		else if (prob > 0.45 && prob < 0.9) {
			gotoxy(puts_life_x, puts_item_y); printf("��");
			gotoxy(12, 12); printf("�� ��ų�� ������ϴ�!!");
		}
		else if (prob > 0.9 && prob < 1) {
			gal->CLEAR_CONDITION_SUM = 42;
		}
	}
	if ((gal->item3_x == gal->missile_x || gal->item3_x == gal->missile_x - 1) && gal->missile_y == 5) {
		gal->ITEM3 = 0;
		gotoxy(gal->item3_x, 5); printf("  ");
		gal->item3_x = 60;
		prob = random();

		if (prob < 0.45) {
			gal->Life++;
			gotoxy(12, 12); printf("�������� ������ϴ�!!");
		}
		else if (prob > 0.45 && prob < 0.9) {
			gotoxy(puts_life_x, puts_item_y); printf("��");
			gotoxy(12, 12); printf("�� ��ų�� ������ϴ�!!");
		}

		else if (prob > 0.9 && prob < 1) {
			gal->EASYMODE_STAGE1_CLEAR = TRUE;
		}
	}

	return;
}

void BOSS_MOVE(struct gallaga *gal) {
	SKILL_TIME(gal);

	/* ���� ���� */
	if (gal->BOSS_HP < 140 && gal->BOSS_HP >90) {
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
		if (gal->overlap == 0) {
			gal->KEY_CONTRARY = 1;
			gal->overlap = 1;
			gotoxy(15, 20); printf("10�ʰ� Ű�� �ݴ�� �۵��մϴ�!!!");
		}
		if (gal->FOR_TIME == 0) {
			time(&s3);
			gal->FOR_TIME = 1;
		}
	}

	if (gal->BOSS_HP <= 90 && gal->BOSS_HP > 40) {
		gal->FOR_TIME = 0;
		gal->overlap = 0;
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
		if (gal->overlap == 0) {
			gal->ATTACK_NUMBER_PLUS = 1;
			if (gal->ATTACK_NUMBER_PLUS) {
				gal->attack_number = 0.6;
				gotoxy(15, 20); printf("���� ���ݾ��� �����մϴ�!!!");
			}
			gal->overlap = 1;
		}
		if (gal->FOR_TIME == 0) {
			time(&s3);
			gal->FOR_TIME = 1;
		}
	}
	if (gal->BOSS_HP <= 40) {
		gal->FOR_TIME = 0;
		gal->overlap = 0;
		SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 12);
		if (gal->overlap == 0) {
			gal->KEY_CONTRARY = 1;
			gal->ATTACK_NUMBER_PLUS = 1;
			gal->overlap = 1;
			if (gal->ATTACK_NUMBER_PLUS) {
				gal->attack_number = 0.6;
				gotoxy(15, 20); printf("���� ���ݾ��� �����մϴ�!!!");
			}
			gotoxy(15, 21);     printf(" Ű�� �ݴ�� �۵��մϴ�!!!");
		}
		if (gal->FOR_TIME == 0) {
			time(&s3);
			gal->FOR_TIME = 1;
		}
	}
	/* ���� ������ ���� */
	/* flag �� ��ȯ */
	if (gal->for_flag == 0) {
		gal->flag = 1;
		gal->for_flag++;
	}
	else if (gal->for_flag == 1) {
		gal->flag = 2;
		gal->for_flag++;
	}
	else if (gal->for_flag == 2) {
		gal->flag = 1;
		gal->for_flag++;
	}
	else if (gal->for_flag == 3) {
		gal->flag = 0;
		gal->for_flag = 0;
	}
	/* flag �� ��ȯ */

	/* BOSS */
	/* ���� */
	if (gal->flag == 0) {
		gotoxy(20, 1);       printf("��������   ");
		gotoxy(18, 2);     printf("����������   ");
		gotoxy(16, 3);   printf("������������   ");
		gotoxy(14, 4);  printf("�������������   ");
		gotoxy(14, 5); printf("��������������   ");
		gotoxy(14, 6); printf("��������������   ");
		gotoxy(14, 7); printf("��������������   ");
		gotoxy(15, 8);  printf("*������������*   ");
		gotoxy(17, 9);    printf("*����������*   ");
		gotoxy(18, 10);    printf("����������  ");
		gotoxy(18, 11);    printf("����������  ");
		gotoxy(18, 12);    printf("����������   ");
		gotoxy(18, 13);    printf("����������  ");
		gotoxy(19, 14);     printf("*��������*   ");
		gotoxy(22, 15);        printf("������   ");
		gal->BOSS_COORD_X1 = 14;
		gal->BOSS_COORD_X2 = 40;
	}

	/* ��� */
	if (gal->flag == 1) {

		gotoxy(19, 1); printf("  ");
		gotoxy(17, 2); printf("  ");
		gotoxy(15, 3); printf("  ");
		gotoxy(13, 4); printf("  ");
		gotoxy(13, 5); printf("  ");
		gotoxy(13, 6); printf("  ");
		gotoxy(13, 7); printf("  ");
		gotoxy(14, 8); printf("  ");
		gotoxy(16, 9); printf("  ");
		gotoxy(17, 10); printf("  ");
		gotoxy(17, 11); printf("  ");
		gotoxy(17, 12); printf("  ");
		gotoxy(17, 13); printf("  ");
		gotoxy(18, 14); printf("  ");
		gotoxy(21, 15); printf("  ");

		gotoxy(22, 1);       printf("��������   ");
		gotoxy(20, 2);     printf("����������  ");
		gotoxy(18, 3);   printf("������������   ");
		gotoxy(16, 4);  printf("�������������   ");
		gotoxy(16, 5); printf("��������������   ");
		gotoxy(16, 6); printf("��������������   ");
		gotoxy(16, 7); printf("��������������   ");
		gotoxy(17, 8);  printf("*������������*   ");
		gotoxy(19, 9);    printf("*����������*   ");
		gotoxy(20, 10);    printf("����������   ");
		gotoxy(20, 11);    printf("����������   ");
		gotoxy(20, 12);    printf("����������   ");
		gotoxy(20, 13);    printf("����������   ");
		gotoxy(21, 14);     printf("*��������*   ");
		gotoxy(24, 15);        printf("������   ");
		gal->BOSS_COORD_X1 = 16;
		gal->BOSS_COORD_X2 = 42;
	}

	/* ������ */
	if (gal->flag == 2) {
		gotoxy(23, 1); printf("  ");
		gotoxy(21, 2); printf("  ");
		gotoxy(19, 3); printf("  ");
		gotoxy(17, 4); printf("  ");
		gotoxy(17, 5); printf("  ");
		gotoxy(17, 6); printf("  ");
		gotoxy(17, 7); printf("  ");
		gotoxy(18, 8); printf("  ");
		gotoxy(20, 9); printf("  ");
		gotoxy(21, 10); printf("  ");
		gotoxy(21, 11); printf("  ");
		gotoxy(21, 12); printf("  ");
		gotoxy(21, 13); printf("  ");
		gotoxy(22, 14); printf("  ");
		gotoxy(25, 15); printf("  ");

		gotoxy(24, 1);       printf("��������    ");
		gotoxy(22, 2);     printf("����������     ");
		gotoxy(20, 3);   printf("������������   ");
		gotoxy(18, 4);  printf("�������������   ");
		gotoxy(18, 5); printf("��������������   ");
		gotoxy(18, 6); printf("��������������    ");
		gotoxy(18, 7); printf("��������������   ");
		gotoxy(19, 8);  printf("*������������*    ");
		gotoxy(21, 9);    printf("*����������*    ");
		gotoxy(22, 10);    printf("����������   ");
		gotoxy(22, 11);    printf("����������   ");
		gotoxy(22, 12);    printf("����������   ");
		gotoxy(22, 13);    printf("����������   ");
		gotoxy(23, 14);     printf("*��������*   ");
		gotoxy(26, 15);        printf("������    ");
		gal->BOSS_COORD_X1 = 18;
		gal->BOSS_COORD_X2 = 44;
	}
	/* ���� ������ ���� */
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	return;
}

void SKILL_TIME(struct gallaga *gal) {
	double buffer = 0;

	time(&s4);

	buffer = difftime(s4, s3);


	if (buffer > 9) {
		if (gal->KEY_CONTRARY) {
			gal->KEY_CONTRARY = 0;
			gotoxy(15, 20); printf("                                          ");
			gotoxy(15, 21); printf("                                          ");
		}
		if (gal->ATTACK_NUMBER_PLUS) {
			gal->ATTACK_NUMBER_PLUS = 0;
			gal->attack_number = 0.3;
			gotoxy(15, 20); printf("                                          ");
			gotoxy(15, 21); printf("                                          ");
		}
	}

	return;
}

void BOSSSTAGE(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0, x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;

	system("mode con cols=80 lines=35");
	MAP_DRAW_BOSSSTAGE();

	/* ����ü �������� �ʱ�ȭ */
	gal->flight_x = 27;
	gal->missile = 0;
	gal->Game_End = 0;
	gal->missile_stop = 0;
	gal->flag = 1;
	gal->for_flag = 0;
	gal->missile_distinguish = 0;
	gal->BOSS_HP = 200;
	gal->KEY_CONTRARY = 0;
	gal->ATTACK_NUMBER_PLUS = 0;
	gal->attack_number = 0.3;
	gal->FOR_TIME = 0;
	gal->overlap = 0;
	/* ����ü �������� �ʱ�ȭ */

	BOSSSTAGE_START(gal);

	while (1) {
		Time_Count_BOSSSTAGE(gal);
		Draw_Life_BOSSSTAGE(gal);
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob <= gal->attack_number) { // Ȯ���� �� ���� ������ �����ϴ� �� (#define attack_number �������� ���� ���� ����)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 ��ǥ���� �������� ��ǥ�� ��´�

														/* ó�� �����Ҷ� ����ó�� */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */

		/* ũ�� for�� 2���� ������ ������, ��ǻ���� ����, �̻��� �߻�, Ű �Է��� ���� �������� ���� */

		BOSS_MOVE(gal);

		for (i = 17; i < 26; i++) {	// 1�� for��
			Time_Count_BOSSSTAGE(gal);

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* ���� Ű �Է��� �޴´ٸ� �Ʒ��� if���� �����Ѵ� */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* ����Ű ���� ���� int���� ������ �Ѿ�� ������ �ι��� ��������� �Ѵ� */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
							}
						}
						break;
					case RIGHT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
							}
						}
						break;

					default:
						break;
					}
				}



				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case ESC:
						return;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			}

			/* Ű �Է��� ���ٸ� �Ʒ��� else���� �����Ѵ� */
			else {
				Time_Count_BOSSSTAGE(gal);

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* gal->missile_distinguish�� �̻����� �߻� ���϶� �� �̻����� �߻� ���ϰ� �ϴ� �����̴� */
				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (BOSS_CLEAR(gal)) {
							system("cls");
							gotoxy(25, 10);  printf("***CLEAR***");
							time(&s5);
							gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;

							system("pause");
							return;
						}

					}
				}
				/* �̻��� �߻� �κ� �� */

				/*���� ��ǻ�� ���� �κ� ����*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 9);
					printf("I");
					gotoxy(attack_x[1][j], i + 8);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 25) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf(" ");
					}
				}
				if (i == 24) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1�� for�� ����

		BOSS_MOVE(gal);

		for (i = 26; i < 35; i++) {	// 2�� for�� ����
			Time_Count_BOSSSTAGE(gal);

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* Ű �Է��� �޴´ٸ� if �� ���� */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
								break;
							}
						}
					case RIGHT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
								break;
							}
						}
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					case ESC:
						return;
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			} // Ű �Է��� ��� ��

			  /*Ű �Է��� ���� ���*/
			else {
				Time_Count_BOSSSTAGE(gal);

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (BOSS_CLEAR(gal)) {
						system("cls");
						gotoxy(25, 10);  printf("***CLEAR***");
						time(&s5);
						gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;
						system("pause");
						return;
					}
				}


				/* �̻��� �߻� �κ� �� */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ���� ��ǻ�� ���� �κ� ���� */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I���� ��ǥ�� gal ����ü�� �Ѱ��ش� */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *���� ��ǥ�� gal ����ü�� �Ѱ��ش�
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 9);
					printf("I");
					gotoxy(attack_x[1][j], i - 10);
					printf("  ");
				}
				if (i == BOSSMODE_Y_END + 1) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf("  ");
					}
				}
				if (i == BOSSMODE_Y_END) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2�� for�� ����

		BOSS_MOVE(gal);
	}// while�� ����	
	return;
}

/* ���ӹ�� ��� �Լ� */
void HOW_PLAY() {
	int i = 2;
	char key = '0';

	system("cls");
	gotoxy(i, 1); printf("==========================GAME MENUAL==========================");
	gotoxy(i, 2); printf("<��ǥ>");
	gotoxy(i, 3); printf("STAGE 1 : �� �̻����� ���� �����ð� �ȿ� (��,��)�� ��� ����");
	gotoxy(i, 4); printf("BOSS STAGE : BOSS�� ���� ������ ����");
	gotoxy(i, 6); printf("<���ӹ��>");
	gotoxy(i, 7); printf("1) Easy mode, Hard mode�� �����ϼ���.");
	gotoxy(i, 8); printf("tip) Hard mode�� �� �̻����� �ſ� �����ϴ�!!");
	gotoxy(i, 10); printf("2) ���� �ϴܿ� ǥ�õ� �⺻ ���� key�� �̿��ؼ� ������ �����ϼ���.");
	gotoxy(i, 11); printf("(-> : ���� �̵�, <- : ���� �̵�, SPACE : �̻��� �߻�, M : ������ ���)");
	gotoxy(i, 13); printf("3) ���� ���� �� ��� ���߽ð� �����ø� P KEY�� �̿��Ͻø� �˴ϴ�");
	gotoxy(i, 15); printf("4) �� �̻���(I)�� ������ Life(��)�� 1�� �����մϴ�");
	gotoxy(i, 17); printf("5) �̻����� �̿��� Item(��,��)�� ���߸� ������ ����� �����մϴ�");
	gotoxy(i, 18); printf("   45%% - Life ����, 45%% - �轺ų, 10%% - ������� Ŭ����");
	gotoxy(i, 20); printf("6) BOSS�� ü�� ��Ȳ�� ���� ������ ���մϴ�");
	gotoxy(i, 21); printf("   (������ ���Ҷ� 10�ʰ� ��ų�� ����մϴ�)");
	gotoxy(i, 23); printf("7) ���� Ŭ����� RANKING�� ����� ID�� �Է����ּ���.");
	gotoxy(i, 24); printf("8) �̻����� �ѹ��� �ϳ����� �߻� �����մϴ�.");
	gotoxy(i, 28); printf("�ڷ� ���ư��÷��� SPACE BAR�� �����ּ���.");

	do {
		key = _getch();
	} while (key != SPACE);


	switch (key) {
	case SPACE:
		system("cls");
		return;
	}
}

void HARD_MODE_STAGE1(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0;
	int x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;

	/* ����ü �������� �ʱ�ȭ */
	for (i = 0; i < 14; i++) {
		gal->CLEAR_CONDITION[i] = 0;
	}
	gal->missile_distinguish = 0;
	gal->flight_x = 27;
	gal->missile = 0;
	gal->item1_x = 10;
	gal->item2_x = 55;
	gal->item3_x = 1;
	gal->item1_go = 1;
	gal->item2_go = 1;
	gal->item3_go = 1;
	gal->Life = 3;
	gal->Game_End = 0;
	gal->EASYMODE_STAGE1_CLEAR = 0;
	gal->missile_stop = 0;
	gal->ITEM1 = 1;
	gal->ITEM2 = 1;
	gal->ITEM3 = 1;
	gal->attack_number = 0.4;
	/* ����ü �������� �ʱ�ȭ */
	MAP_DRAW_HARD_STAGE1();
	OBSTACLE_COORD(gal);

	/* ���� ���� �� time count ���� ���� */
	gotoxy(gal->flight_x, user_y_end);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("��");
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	gotoxy(user_x_center, user_y_center);
	puts("READY !!");
	Sleep(3000);
	gotoxy(user_x_center, user_y_center);
	puts("START !!");
	Sleep(500);
	gotoxy(user_x_center, user_y_center);
	puts("        ");
	time(&s1);
	/* ���� ���� �� time count ���� ���� */


	while (1) {	// while �� ����
		Time_Count();
		Draw_Life(gal);
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob < gal->attack_number) { // Ȯ���� �� ���� ������ �����ϴ� �� (#define attack_number �������� ���� ���� ����)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 ��ǥ���� �������� ��ǥ�� ��´�

														/* ó�� �����Ҷ� ����ó�� */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */

		/* ũ�� for�� 2���� ������ ������, ��ǻ���� ����, �̻��� �߻�, Ű �Է��� ���� �������� ���� */
		for (i = 8; i < 16; i++) {	// 1�� for��
			Time_Count();
			gotoxy(12, 12); printf("                         ");
			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return;
			}

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* ���� Ű �Է��� �޴´ٸ� �Ʒ��� if���� �����Ѵ� */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* ����Ű ���� ���� int���� ������ �Ѿ�� ������ �ι��� ��������� �Ѵ� */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // ���� �ִ� ���� �����
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // �����ִ� ���� �����
							printf(" ");
							break;
						}
					default:
						break;
					}
				}

				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;

					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;

					case 'A':
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case ESC:
						return;
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			}

			/* Ű �Է��� ���ٸ� �Ʒ��� else���� �����Ѵ� */
			else {
				Time_Count();

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* ������ �����̴� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x++;
					}
					if (gal->ITEM2) {
						gal->item2_x--;
					}
					if (gal->ITEM3) {
						gal->item3_x++;
					}
				}
				/*1,3�� �����۰� 2�� �������� ������ �ݴ�� �����δ�*/

				/* gal->missile_distinguish�� �̻����� �߻� ���϶� �� �̻����� �߻� ���ϰ� �ϴ� �����̴� */
				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
								EASY_MODE_STAGE1_CLEAR(gal);
							}
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						ITEM_ACT(gal);

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (gal->EASYMODE_STAGE1_CLEAR) {
							system("cls");
							gotoxy(25, 10);
							printf("***CLEAR***");
							time(&s2);
							gal->STAGE1_TIME = difftime(s2, s1);
							system("pause");
							return;
						}

					}
				}
				/* �̻��� �߻� �κ� �� */

				/*���� ��ǻ�� ���� �κ� ����*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 8);
					printf("I");
					gotoxy(attack_x[1][j], i + 7);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 15) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[1][k], user_y_end);
						printf(" ");
					}
				}
				if (i == 15) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1�� for�� ����

		for (i = 16; i < 24; i++) {	// 2�� for�� ����
			Time_Count();
			gotoxy(12, 12); printf("                         ");

			if (gal->EASYMODE_STAGE1_CLEAR) {
				system("cls");
				gotoxy(25, 10);
				printf("***CLEAR***");
				time(&s2);
				gal->STAGE1_TIME = difftime(s2, s1);
				system("pause");
				return;
			}

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* Ű �Է��� �޴´ٸ� if �� ���� */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->flight_x > 2) {
							gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x + move_x + 1, user_y_end); // ���� �ִ� ���� �����
							printf(" ");
							break;
						}
					case RIGHT:
						if (gal->flight_x < 54) {
							gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
							gotoxy(gal->flight_x, user_y_end); // �̵��� ��ǥ�� ��´�
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
							printf("��");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
							gotoxy(gal->flight_x - move_x, user_y_end); // �����ִ� ���� �����
							printf(" ");
							break;
						}
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = user_y_end - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							puts("I");
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'm':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case 'M':
						if (gal->ITEM2) {
							gal->ITEM2 = 0;
							gotoxy(12, 12); printf("�� ��ų �ߵ�!!");
							for (j = 0; j < 14; j++) {
								if (gal->flight_x == gal->EASYMODE_obs_x[0][j] || gal->flight_x == gal->EASYMODE_obs_x[0][j] + 1
									|| gal->flight_x == gal->EASYMODE_obs_x[0][j] + 2) {
									gal->CLEAR_CONDITION[j] = 3;
								}
							}
							for (k = user_y_end; k > 0; k--) {
								Sleep(30);
								gotoxy(gal->flight_x, k); printf("��");
								gotoxy(gal->flight_x, k + 1); printf(" ");
							}
							gotoxy(gal->flight_x, 1); printf("  ");
							gotoxy(puts_life_x, puts_item_y); printf("  ");
							gotoxy(12, 12); printf("           ");
						}
						break;
					case CHEATKEY:
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case 'A':
						gal->EASYMODE_STAGE1_CLEAR = 1;
						break;
					case ESC:
						return;

					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			} // Ű �Է��� ��� ��

			  /*Ű �Է��� ���� ���*/
			else {
				Time_Count();

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* ������ �����̴� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 14);
				for (j = 0; j < Item_Velocity; j++) {
					if (gal->ITEM1) {
						gotoxy(gal->item1_x, 1);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM2) {
						gotoxy(gal->item2_x, 3);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM3) {
						gotoxy(gal->item3_x, 5);
						if (i % 2) {
							puts("��");
						}
						else {
							puts("��");
						}
					}
					if (gal->ITEM1) {
						gal->item1_x--;
					}
					if (gal->ITEM2) {
						gal->item2_x++;
					}
					if (gal->ITEM3) {
						gal->item3_x--;
					}
				}
				/* ������ �����̴� �κ� �� */

				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						if (gal->missile_y == 2 || gal->missile_y == 4 || gal->missile_y || 6) {
							EASY_MODE_STAGE1_CLEAR(gal);
						}
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					ITEM_ACT(gal);

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (gal->EASYMODE_STAGE1_CLEAR) {
						system("cls");
						gotoxy(25, 10);
						printf("***CLEAR***");
						time(&s2);
						gal->STAGE1_TIME = difftime(s2, s1);
						system("pause");
						return;
					}
				}


				/* �̻��� �߻� �κ� �� */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ���� ��ǻ�� ���� �κ� ���� */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I���� ��ǥ�� gal ����ü�� �Ѱ��ش� */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *���� ��ǥ�� gal ����ü�� �Ѱ��ش�
				}
				if (i == user_y_end) {
					for (k = 0; k < 25; k++) {
						gotoxy(attack_x[0][k], user_y_end);
						printf(" ");
					}
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 8);
					printf("I");
					gotoxy(attack_x[1][j], i - 9);
					printf("  ");
				}
				if (i == user_y_end) {
					Minus_Life(gal);
					Draw_Life(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2�� for�� ����

	}// while�� ����	
	return;
}

void BOSSSTAGE_HARD(struct gallaga *gal) {
	char key;
	int i = 0, j = 0, k = 0, x = 0, y = 0;
	float prob = 0;
	int attack_x[2][25] = { 0 };
	int start = 1;

	system("mode con cols=80 lines=35");
	MAP_DRAW_BOSSSTAGE();

	/* ����ü �������� �ʱ�ȭ */
	gal->flight_x = 27;
	gal->missile = 0;
	gal->Life = 3;
	gal->Game_End = 0;
	gal->missile_stop = 0;
	gal->flag = 1;
	gal->for_flag = 0;
	gal->missile_distinguish = 0;
	gal->BOSS_HP = 200;
	gal->KEY_CONTRARY = 0;
	gal->ATTACK_NUMBER_PLUS = 0;
	gal->attack_number = 0.4;
	gal->FOR_TIME = 0;
	gal->overlap = 0;
	/* ����ü �������� �ʱ�ȭ */

	BOSSSTAGE_START(gal);

	while (1) {
		Time_Count_BOSSSTAGE(gal);
		Draw_Life_BOSSSTAGE(gal);
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */
		for (i = 0; i < 25; i++) {
			prob = random();
			if (prob <= gal->attack_number) { // Ȯ���� �� ���� ������ �����ϴ� �� (#define attack_number �������� ���� ���� ����)
				attack_x[0][i] = (int)(random() * 55);  // 1~55 ��ǥ���� �������� ��ǥ�� ��´�

														/* ó�� �����Ҷ� ����ó�� */
				if (start) {
					attack_x[1][i] = (int)(random() * 55);
				}
			}
		}
		/* ��ǻ���� ������ ��������  ������ �ϴ� �� */

		/* ũ�� for�� 2���� ������ ������, ��ǻ���� ����, �̻��� �߻�, Ű �Է��� ���� �������� ���� */

		BOSS_MOVE(gal);

		for (i = 17; i < 26; i++) {	// 1�� for��
			Time_Count_BOSSSTAGE(gal);

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* ���� Ű �Է��� �޴´ٸ� �Ʒ��� if���� �����Ѵ� */
			if (_kbhit()) {
				i--;
				key = _getch();
				/* ����Ű ���� ���� int���� ������ �Ѿ�� ������ �ι��� ��������� �Ѵ� */
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						/* Ű �ݴ� ��ų�� Ȱ��ȭ �� ���� �� */
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
							}
						}
						/* Ű �ݴ� ��ų�� Ȱ��ȭ ���� �� */
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
							}
						}
						break;
					case RIGHT:
						/* Ű �ݴ� ��ų�� Ȱ��ȭ �� ���� �� */
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
							}
						}
						/* Ű �ݴ� ��ų�� Ȱ��ȭ ���� �� */
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
							}
						}
						break;

					default:
						break;
					}
				}



				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					case ESC:
						return;

					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			}

			/* Ű �Է��� ���ٸ� �Ʒ��� else���� �����Ѵ� */
			else {
				Time_Count_BOSSSTAGE(gal);

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* gal->missile_distinguish�� �̻����� �߻� ���϶� �� �̻����� �߻� ���ϰ� �ϴ� �����̴� */
				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					for (j = 0; j < 4; j++) {
						if (gal->missile_stop != TRUE) {
							gotoxy(gal->missile_x, gal->missile_y);
							printf(" ");
							gal->missile_y = gal->missile_y - 1;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}

						if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
							gal->missile_distinguish = FALSE;
						}

						if (BOSS_CLEAR(gal)) {
							system("cls");
							gotoxy(25, 10);  printf("***CLEAR***");
							time(&s5);
							gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;
							system("pause");
							return;
						}

					}
				}
				/* �̻��� �߻� �κ� �� */

				/*���� ��ǻ�� ���� �κ� ����*/
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");
				}

				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i + 9);
					printf("I");
					gotoxy(attack_x[1][j], i + 8);
					printf("  ");

					gal->computer_attack_x_coord[j] = attack_x[1][j];

				}
				if (i == 25) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf(" ");
					}
				}
				if (i == 24) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 1�� for�� ����

		BOSS_MOVE(gal);

		for (i = 26; i < 35; i++) {	// 2�� for�� ����
			Time_Count_BOSSSTAGE(gal);

			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */
			for (j = 0; j <= user_x_end; j++) {
				gotoxy(j, 0);
				printf(" ");
			}
			/* �̻����� �� ���� �ٴٶ��� �� �����ֱ� ���� for�� */

			/* Ű �Է��� �޴´ٸ� if �� ���� */
			if (_kbhit()) {
				i--;
				key = _getch();
				if (key == -32) {
					key = _getch();
					switch (key) {
					case LEFT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
								break;
							}
						}
					case RIGHT:
						if (gal->KEY_CONTRARY == 0) {
							if (gal->flight_x < 54) {
								gal->flight_x = gal->flight_x + move_x; // 2��ŭ ���������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x - move_x, BOSSMODE_Y_END); // �����ִ� ���� �����
								printf(" ");
								break;
							}
						}
						else if (gal->KEY_CONTRARY) {
							if (gal->flight_x > 2) {
								gal->flight_x = gal->flight_x - move_x; // 2��ŭ �������� �̵�
								gotoxy(gal->flight_x, BOSSMODE_Y_END); // �̵��� ��ǥ�� ��´�
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
								printf("��");
								SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
								gotoxy(gal->flight_x + move_x + 1, BOSSMODE_Y_END); // ���� �ִ� ���� �����
								printf(" ");
								break;
							}
						}
					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
				else {
					switch (key) {
					case SPACE:
						Beep(SOL, TIME);
						gal->missile_stop = FALSE;
						if (gal->missile_distinguish == FALSE) {
							gal->missile_distinguish = 1;
							gal->missile_y = BOSSMODE_Y_END - 1;
							gal->missile_x = gal->flight_x;
							gotoxy(gal->missile_x, gal->missile_y);
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
							puts("I");
							SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
						}
						break;
					case PAUSE:
						gotoxy(22, 11);
						printf("�� �Ͻ� ���� ��\n");
						gotoxy(15, 12);
						system("pause");
						gotoxy(22, 11);
						printf("                  ");
						gotoxy(15, 12);
						printf("                                     ");
						break;
					case 'a':
						gal->BOSS_HP = 40;
						break;
					case 'A':
						gal->BOSS_HP = 40;
						break;
					case 'e':
						gal->BOSS_HP = 0;
						break;
					case 'E':
						gal->BOSS_HP = 0;
						break;
					case ESC:
						return;

					default:
						break;
					}
				}
				/* �̻����� ��� ��� */
			} // Ű �Է��� ��� ��

			  /*Ű �Է��� ���� ���*/
			else {
				Time_Count_BOSSSTAGE(gal);

				/* �� ������ Game_Speed�� �����Ѵ� */
				Sleep(gal->GAME_SPEED);

				/* �Ʒ��� if���� �̻����� �߻��ϴ� ��ó�� ���̰� �ϴ� �κ� */
				SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
				if (gal->missile_distinguish) {
					if (gal->missile_stop != TRUE) {
						gotoxy(gal->missile_x, gal->missile_y);
						printf(" ");
						gal->missile_y = gal->missile_y - 1;
						gotoxy(gal->missile_x, gal->missile_y);
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 8);
						puts("I");
						SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
					}

					if (gal->missile_y == 0 || gal->missile_stop == TRUE) {
						gal->missile_distinguish = FALSE;
					}

					if (BOSS_CLEAR(gal)) {
						system("cls");
						gotoxy(25, 10);  printf("***CLEAR***");
						time(&s5);
						gal->TOTAL_TIME = difftime(s5, s1) + gal->STAGE1_TIME;
						system("pause");
						return;
					}
				}


				/* �̻��� �߻� �κ� �� */


				if (start = TRUE) {
					start = 0;
				}

				else {
					for (j = 0; j < 25; j++) {
						prob = random();
						if (prob < gal->attack_number) {
							attack_x[1][j] = (int)(random() * 55);
						}
					}
				}

				/* ���� ��ǻ�� ���� �κ� ���� */
				Sleep(30);
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[0][j], i);
					printf("I");
					gotoxy(attack_x[0][j], i - 1);
					printf("  ");

					/* I���� ��ǥ�� gal ����ü�� �Ѱ��ش� */
					gal->computer_attack_x_coord[j] = attack_x[0][j]; // *���� ��ǥ�� gal ����ü�� �Ѱ��ش�
				}
				for (j = 0; j < 25; j++) {
					gotoxy(attack_x[1][j], i - 9);
					printf("I");
					gotoxy(attack_x[1][j], i - 10);
					printf("  ");
				}
				if (i == BOSSMODE_Y_END + 1) {
					for (k = 0; k < 55; k++) {
						gotoxy(k, BOSSMODE_Y_END + 1);
						printf("  ");
					}
				}
				if (i == BOSSMODE_Y_END) {
					Minus_Life_BOSSSTAGE(gal);
					Draw_Life_BOSSSTAGE(gal);
					if (gal->Game_End) {
						FAIL();
						return;
					}
				}
			}
		}	// 2�� for�� ����

		BOSS_MOVE(gal);
	}// while�� ����	
	return;

	return;
}

void MAP_DRAW_HARD_STAGE1() {
	int i = 0;

	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	gotoxy(easy_mode_menu, puts_easymode_y);
	puts("HARD Mode");
	gotoxy(easy_mode_menu, puts_time_y);
	puts("time : ");
	gotoxy(easy_mode_menu, puts_besttime_y);
	puts("Best time :");
	gotoxy(easy_mode_menu, puts_life_y);
	puts("Life : ");
	gotoxy(easy_mode_menu, puts_item_y);
	puts("Item : ");
	gotoxy(easy_mode_menu, puts_SPACE_y);
	puts("SPACE : Launch");
	gotoxy(easy_mode_menu, puts_M_y);
	puts("M : Item use");
	gotoxy(easy_mode_menu, puts_P_y);
	puts("P : Pause");
	gotoxy(easy_mode_menu, puts_ESC_y);
	puts("ESC : Quit");

	for (i = 0; i < user_y_end + 1; i++) {
		gotoxy(57, i); puts("��");
	}

	gotoxy(57, 7);
	printf("����������������������");

	gotoxy(57, 13);
	printf("����������������������");

	gotoxy(3, 2);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("�� ��   �� ��   �� ��   �� ��   �� ��   �� ��   �� ��"); //x��ǥ 1 4  9 12  17 20  25 28  33 36  41 44  49 52
	gotoxy(3, 4);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	puts("�� ��   �� ��   �� ��   �� ��   �� ��   �� ��   �� ��"); //55,4
	gotoxy(3, 6);
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 9);
	puts("�� ��   �� ��   �� ��   �� ��   �� ��   �� ��   �� ��"); //55,2
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);

	return;
}

/* ������� ��ŷ�� �ű�� �Լ� */
void RANKING_EASY(struct gallaga *gal) {
	char ch = '0';
	int i = 0, j = 0, k = 0, l = 0, m = 0;
	int buffer = 0;
	char ch_buffer[20];

	gal->USER_NUM_EASY++;

	printf("INPUT USER NAME : ");
	while (ch != '\n') {
		ch = getchar();
		gal->ID_EASY[gal->USER_NUM_EASY - 1][i] = ch;
		i++;
	}

	/* USER_tIME�� ������� �� �ɸ� �ð��� �־��ش� */
	gal->USER_TIME_EASY[gal->USER_NUM_EASY - 1] = gal->TOTAL_TIME;

	/* �ð� �������� ������������ ���� -> ��, ª�� �ð������� ��ũ */
	for (l = 0; l < gal->USER_NUM_EASY - 1; l++) {
		for (i = 0; i < gal->USER_NUM_EASY - 1; i++) {
			for (j = 0; j < gal->USER_NUM_EASY - 1; j++) {
				if (gal->USER_TIME_EASY[j] > gal->USER_TIME_EASY[j + 1]) {
					buffer = gal->USER_TIME_EASY[j];
					gal->USER_TIME_EASY[j] = gal->USER_TIME_EASY[j + 1];
					gal->USER_TIME_EASY[j + 1] = buffer;

					k = 0;
					for (m = 0; m < 20; m++) {
						ch_buffer[m] = '0';
					}
					while (ch_buffer[k] != '\n') {
						ch_buffer[k] = gal->ID_EASY[l][j];
						gal->ID_EASY[l][j] = gal->ID_EASY[l][j + 1];
						gal->ID_EASY[l][j + 1] = ch_buffer[k];
					}
				}
			}
		}
	}
	/* �� ������ ������ �ð��� ª�� ������� ID�� gal->ID[0]����, �ð��� gal->USER_TIME[0]���� ��ũ�ȴ� */

	return;
}

/* ������� ��ŷ�� �����ִ� �Լ� */
void SHOW_RANKING_EASY(struct gallaga *gal) {
	int i = 0, j = 0;
	int minute[10] = { 0, }, sec[10] = { 0, };
	int buffer[10] = { 0, };
	char ch = '0';

	for (i = 0; i < gal->USER_NUM_EASY; i++) {
		buffer[i] = gal->USER_TIME_EASY[i];
		minute[i] = buffer[i] / 60;
		sec[i] = buffer[i] % 60;
	}

	gotoxy(1, 1); printf("===================RANKING LIST (EASY)===================\n");
	for (i = 0; i < gal->USER_NUM_EASY; i++) {
		if (buffer[i] < 60) {
			gotoxy(1, i + 2);
			printf("%d�� ", i + 1);
			printf("%d�� ", sec[i]);
			j = 0;
			ch = '0';
			while (ch != '\n') {
				ch = gal->ID_EASY[i][j];
				printf("%c", ch);
				j++;
			}
		}
		else {
			printf("%d�� ", i + 1);
			printf("%d�� %d��", minute[i], sec[i]);
			j = 0;
			while (ch != '\n') {
				ch = gal->ID_EASY[i][j];
				printf("%c", ch);
				j++;
			}
		}
	}

	system("pause");
	return;

}

/* �ϵ��� ��ŷ�� �ű�� �Լ� */
void RANKING_HARD(struct gallaga *gal) {
	char ch = '0';
	int i = 0, j = 0, k = 0, l = 0, m = 0;
	int buffer = 0;
	char ch_buffer[20];

	gal->USER_NUM_HARD++;

	printf("INPUT USER NAME : ");
	while (ch != '\n') {
		ch = getchar();
		gal->ID_HARD[gal->USER_NUM_HARD - 1][i] = ch;
		i++;
	}

	/* USER_tIME�� ������� �� �ɸ� �ð��� �־��ش� */
	gal->USER_TIME_HARD[gal->USER_NUM_HARD - 1] = gal->TOTAL_TIME;

	/* �ð� �������� ������������ ���� -> ��, ª�� �ð������� ��ũ */
	for (l = 0; l < gal->USER_NUM_HARD - 1; l++) {
		for (i = 0; i < gal->USER_NUM_HARD - 1; i++) {
			for (j = 0; j < gal->USER_NUM_HARD - 1; j++) {
				if (gal->USER_TIME_HARD[j] > gal->USER_TIME_HARD[j + 1]) {
					buffer = gal->USER_TIME_HARD[j];
					gal->USER_TIME_HARD[j] = gal->USER_TIME_HARD[j];
					gal->USER_TIME_HARD[j] = buffer;

					k = 0;
					for (m = 0; m < 20; m++) {
						ch_buffer[m] = '0';
					}
					while (ch_buffer[k] != '\n') {
						ch_buffer[k] = gal->ID_HARD[l][j];
						gal->ID_HARD[l][j] = gal->ID_HARD[l][j + 1];
						gal->ID_HARD[l][j + 1] = ch_buffer[k];
					}
				}
			}
		}
	}
	/* �� ������ ������ �ð��� ª�� ������� ID�� gal->ID[0]����, �ð��� gal->USER_TIME[0]���� ��ũ�ȴ� */

	return;
}

/* �ϵ��� ��ŷ�� �����ִ� �Լ� */
void SHOW_RANKING_HARD(struct gallaga *gal) {
	int i = 0, j = 0;
	int minute[10] = { 0, }, sec[10] = { 0, };
	int buffer[10] = { 0, };
	char ch = '0';

	for (i = 0; i < gal->USER_NUM_HARD; i++) {
		buffer[i] = gal->USER_TIME_HARD[i];
		minute[i] = buffer[i] / 60;
		sec[i] = buffer[i] % 60;
	}

	gotoxy(1, 1); printf("===================RANKING LIST (HARD)===================\n");
	for (i = 0; i < gal->USER_NUM_HARD; i++) {
		if (buffer[i] < 60) {
			gotoxy(1, i + 2);
			printf("%d�� ", i + 1);
			printf("%d�� ", sec[i]);
			j = 0;
			ch = '0';
			while (ch != '\n') {
				ch = gal->ID_HARD[i][j];
				printf("%c", ch);
				j++;
			}
		}
		else {
			printf("%d�� ", i + 1);
			printf("%d�� %d��", minute[i], sec[i]);
			j = 0;
			while (ch != '\n') {
				ch = gal->ID_HARD[i][j];
				printf("%c", ch);
				j++;
			}
		}
	}

	system("pause");
	return;

}

/* ��ũ ���� ��� ���� */
char select_rank() {
	char MODE = '0';

	puts("");
	puts("     ����            ");
	puts("   ��      ��       �� ��                             �Ȧ� �� �� �� �� �� �� ����");
	puts("   ��                �� ��                            ��  1. EASY MODE RANK    ��");
	puts("   ��                �� ��                            ��                       ��");
	puts("   ��    ���  ���  �� ��   ���    ���   ���      ��                       ��");
	puts("   ��      �� ��  ��  �� �� ��  ��  ��  �� ��  ��     ��                       ��");
	puts("     ����    ����  �� �� ����  ���   ����    ��  2. HARD MODE RANK    ��");
	puts("                                        ��            �Ŧ� �� �� �� �� �� �� ����");
	puts("                                     ��� ");

	do {
		MODE = _getch();
	} while (MODE<'1' || MODE>'2');
	system("cls");

	return MODE;
}

void Game_Option(struct gallaga *gal) {

	gotoxy(20, 8);
	printf("GAME SPEED ���ڸ� �Է����ּ���\n    (0~100�� ���ڸ� �Է����ּ��� ���ڰ� Ŀ������ �ӵ��� �������ϴ�.)\n");
	scanf_s("%d", &(gal->GAME_SPEED));

	return;
}
/* �Լ� ���� �� */