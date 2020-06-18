/*

## 2018�� 2�г� 1�б� ����Ʈ����� ������Ʈ
## ������б� ������Ű��а�
## 2014707073 ���ȯ
## c���� �����غ� ������

*/

#include <stdio.h>
#include "gallaga.h"
#pragma comment(lib,"winmm.lib")
#include <mmsystem.h>

struct gallaga gal;

void main() {
	char key = NULL;
	char Game_Mode = 0;
	int i = 0;
	char RANK_MODE = NULL;

	/* ������ �ʱ�ȭ */
	variable_initiate(&gal);

	/* �ð��� ���� ���� ���� �߻��� ���� */
	srand((unsigned)time(NULL));

	/* BGM  ��� */
	PlaySound(TEXT("gallaga.wav"), NULL, SND_ASYNC | SND_LOOP);
	start();

	/* ������ ���� */
	while (1) {
		/* ����ȭ�� ũ�� ���� */
		system("mode con cols=81 lines=25");
		/* �޴�ȭ�� */
		key = Menu();
		switch (key) {
		case '1':
			/* ���Ӹ�� ����ȭ�� */
			Game_Mode = Game_Start();
			switch (Game_Mode) {
			case '1':
				/* ������� STAGE1 ���� */
				EASY_MODE_STAGE1(&gal);
				system("cls");
				/* ������� BOSS STAGE ���� */
				if (gal.EASYMODE_STAGE1_CLEAR) {
					BOSSSTAGE(&gal);
					if (BOSS_CLEAR(&gal)) {
						RANKING_EASY(&gal);
						system("cls");
						SHOW_RANKING_EASY(&gal);
					}
				}
				break;
			case '2':
				HARD_MODE_STAGE1(&gal);
				system("cls");
				if (gal.EASYMODE_STAGE1_CLEAR) {
					BOSSSTAGE_HARD(&gal);
					if (BOSS_CLEAR(&gal)) {
						RANKING_HARD(&gal);
						system("cls");
						SHOW_RANKING_HARD(&gal);
					}
				}
				break;
			case '3':
				system("mode con cols=85 lines=30");
				HOW_PLAY();
				break;
			}
			break;
		case '2':
			RANK_MODE = select_rank();
			switch (RANK_MODE) {
			case '1':
				SHOW_RANKING_EASY(&gal);
				break;
			case '2':
				SHOW_RANKING_HARD(&gal);
				break;
			}
			break;
		case '3':
			Game_Option(&gal);
			break;
		case '4':
			PlaySound(NULL, NULL, NULL);
			return;
		}
		system("cls");
	}

	PlaySound(NULL, NULL, NULL);
	return;
}