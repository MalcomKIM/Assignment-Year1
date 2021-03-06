// Assembly2.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "stdlib.h"
#include <string>
#include <iostream>
#include <stdio.h>
#include <cmath>

using namespace std;

int main()
{	
	char enter_looptime[] = "Enter number of students (between 3-10):";
	char student_ID_format[] = "Enter Student ID [%d]: ";
	char student_ID_warning[] = "Warning: Invalid Student ID. Must be between 18000 to 18999.\n";
	char student_name_format[] = "Enter Student Name [%d]: ";
	char student_name_warning[] = "Warning: Invalid Student Name. Must be 10 characters or less.\n";
	char Grade_format[] = "Enter Grade [%d]: ";
	char grade_warning[] = "Warning: Invalid Grade. Must be between 0 to 100.\n";
	char result[] = "List of Student IDs, Student Names and their Grades:\n";
	char fail_format[] = "Number of students who failed is %d\n";
	char mean[] = "Mean is %d";
	char deviation_format[] = "Standard deviation is %.4f\n";
	char end[] = "Program ends.\n";

	char int_format[] = "%d";
	char double_format[] = "%lf";
	char string_format[] = "\r%[^\n]";
	char int_tab[] = "%d\t";
	char tab_int[] = "\t%d";
	char newline[] = "\n";
	char order[] = "%d. ";
	char fraction1[] = ".%d\n";

	int student_ID[10];
	memset(student_ID, 0, sizeof(student_ID));
	int ID_address = -4;
	char student_name[10][30];
	memset(student_name, 0, sizeof(student_name));
	int grade[10];
	memset(grade, 0, sizeof(grade));
	int loopCounter = 0;
	int current_loop = 1;
	int sum = 0;
	int average = 0;
	int square_sum = 0;
	int sum_square = 1;
	int dividend=0;
	float divisor = 1;
	float deviation;
	int fraction_part = 0;
	int fail = 0;


	_asm {
	looptimes:							//Fuction: to ensure looptimes which the user input is greater than 3 and less than 10
		lea eax, enter_looptime;
		push eax;
		call printf;					//Print "Enter number of students (between 3-10):" on the screen
		add esp, 4;

		lea eax, loopCounter;
		push eax;
		lea eax, int_format;
		push eax;
		call scanf_s;					//Input the times for loop
		add esp, 8;

		mov eax, loopCounter;
		cmp eax, 3;						//Judge whether the valuable named "loopCounter" is less than 3 or not
		jl looptimes;					//Jump to "looptimes" if "loopCounter" is less than 3 for another valid input
		cmp eax, 10;					//Judge whether the valuable named "loopCounter" is greater than 10 or not
		jg looptimes;					//Jump to "looptimes" if "loopCounter" is greater than 10 for another valid input

		mov ecx, loopCounter;			//Save the value of "loopCounter" in ecx

		lea edi, student_name;			//Save the head address of "student_name" in edi

	input_loop:							//The input loop starts here!
		push ecx;						//Protect the value of ecx
		add ID_address, 4;				//Let the "ID_address" be 0 at first, add 4 for each loop
		mov esi, ID_address;			//Save the value of "ID_address" in esi

		jmp input_student_ID;			//Jump to "input_student_ID"

	add_newline:						//Fuction: add a newline between two students' input
		lea eax, newline;
		push eax;
		call printf;
		add esp, 4;

		inc current_loop;				//To record the current loop's number in current_loop

		pop ecx;						//ecx minus 1 for each loop 
		loop input_loop;				//Loop ends

		jmp sort;						//Jump to "sort"

		//===========================ID==============================

	input_student_ID:					//Fuction: to ensure that all the input student IDs are valid
		mov eax, current_loop;			//Save the value of current_loop in eax
		push eax;
		lea eax, student_ID_format;
		push eax;
		call printf;					// Print "Enter Student ID [current_loop]:" on the screen
		add esp, 8;

		lea eax, student_ID[esi];		//Save the current address of student_ID in eax
		push eax;
		lea eax, int_format;
		push eax;
		call scanf_s;					//Input the student ID
		add esp, 8;

		mov eax, student_ID[esi];		//Save the value of student_ID[esi] in eax
		cmp eax, 18000;					//Judge whether the ID is less than 18000 or not
		jl invalid_ID;					//if the ID is less than 18000, jump to "invalid_ID"
		cmp eax, 18999;					//Judge whether the ID is greater than 18999 or not
		jg invalid_ID;					//if the ID is greater than 18999, jump to "invalid_ID"
		jmp input_student_name;			//If the input ID satisfy all the conditions, jump to "input_student_name"

	invalid_ID:							//Function: to tell the user that the input student ID is invalid
		lea eax, student_ID_warning;
		push eax;
		call printf;					//Print "Warning: Invalid Student ID. Must be between 18000 to 18999." on the screen
		add esp, 4;
		jmp input_student_ID;			//Jump to the "input_student_ID", let the user input the student ID again

		//==============================name====================================

	input_student_name:					//Fuction: to ensure that all the input student names are valid
		mov eax, current_loop;			//Save the value of current_loop in eax
		push eax;
		lea eax, student_name_format;
		push eax;
		call printf;					//Print "Enter Student Name [current_loop]:" on the screen
		add esp, 8;

		lea  eax, [edi];				
		push eax;
		lea  eax, string_format;
		push eax;
		call scanf;						//Input the student name which will be saved in student_name[edi]
		add  esp, 8;

		lea eax, [edi];					//Save the content of student_name[edi] in eax
		push eax;
		call strlen;					//Call the strlen fuction to return the length of the input student name to eax 
		add esp, 4;
		cmp eax, 10;					//Compare the length of the input student name with 10
		jg invalid_name;				//If the length of the input student name is greater than 10, jump to the "invalid_name"

		add edi, 30;					//Since the initialization of student name is student_name[10][30], add 30 to edi every loop for next input
		jmp input_grade;				//If the input name satisfy all the conditions, jump to "input_grade"

	invalid_name:						//Function: to tell the user that the input student name is invalid
		lea eax, student_name_warning;
		push eax;
		call printf;					//Print "Warning: Invalid Student Name. Must be 10 characters or less." on the screen
		add esp, 4;
		jmp input_student_name;			//Jump to the "input_student_name", let the user input the student name again

		//===============================grade===================================

	add_fail:							//Function: to record the number of students who fail 
		inc fail;						//Add 1 to variable fail;
		jmp add_newline;				//Jump to "add_newline"

	invalid_grade:						//Function: to tell the user that the input grade is invalid
		lea eax, grade_warning;
		push eax;
		call printf;					//Print "Warning: Invalid Grade. Must be between 0 to 100." on the screen
		add esp, 4;
		jmp input_grade;				//Jump to the "input_grade", let the user input the student grade again

	input_grade:						//Fuction: to ensure that all the input grades are valid
		mov eax, current_loop;			//Save the value of current_loop in eax
		push eax;
		lea eax, Grade_format;
		push eax;
		call printf;					//Print "Enter Grade [current_loop]:" on the screen
		add esp, 8;

		lea eax, grade[esi];			//Save the current address of grade in eax
		push eax;
		lea eax, int_format;
		push eax;
		call scanf_s;					//input the grade
		add esp, 8;

		mov eax, grade[esi];			//Save the value of grade[esi] in eax
		cmp eax, 0;						//Compare the grade with 0
		jl invalid_grade;				//If the grade is less than 0, jump to "invalid_grade"
		cmp eax, 100;					//Compare the grade with 100
		jg invalid_grade;				//If the grade is greater than 100, jump to "invalid_grade"

		cmp eax, 40;					//Compare the grade with 40
		jl add_fail;					//If the grade is less than 40, jump to "add_fail"
		jge add_newline;

		//===============================bubble sort===========================

	sort:								//Fuction: use the bubble sort to generate a sorted list from highest to lowest grade
		mov ecx, loopCounter;			//Save the value of loopCounter in ecx
		dec ecx;						//ecx minus 1

	L1:									//First loop
		push ecx;						//Protect the value in ecx
		mov esi, 0;						//Initialize esi equal to 0
		lea edi, student_name;			//Save the head address of student_name in edi
		
	L2:									//Second loop
		mov eax, grade[esi];			//Save the value of grade[esi] in eax
		cmp grade[esi + 4], eax;		//Compare the value of grade[esi + 4] and grade[esi]
		jle L3;							//If the value of grade[esi + 4] is less than or equal to grade[esi], jump to "L3"
		xchg eax, grade[esi + 4];		//Else, exchange the value of eax and grade[esi + 4]
		mov grade[esi], eax;			//Let the grade[esi] equals eax. 

	name_swap:							//Fuction: swap two students' name
		mov eax, [edi];					//Save the content of student_name[edi] in eax
		xchg eax, [edi + 30];			//Exchange the value of eax and student_ID[edi + 30]
		mov [edi], eax;					//Let the student_name[edi] equals eax
		mov eax, [edi+4];				//Save the content of student_name[edi+4] in eax
		xchg eax, [edi + 34];			//Exchange the value of eax and student_ID[edi + 34]
		mov [edi+4], eax;				//Let the student_name[edi+4] equals eax
		mov eax, [edi + 8];				//Save the content of student_name[edi+8] in eax
		xchg eax, [edi + 38];			//Exchange the value of eax and student_ID[edi + 38]
		mov[edi + 8], eax;				//Let the student_name[edi+8] equals eax

		mov eax, student_ID[esi];		//Save the value of student_ID[esi] in eax
		xchg eax, student_ID[esi + 4];	//Exchange the value of eax and student_ID[esi + 4]
		mov student_ID[esi], eax;		//Let the student_ID[esi] equals eax

	L3:
		add esi, 4;						//Add 4 to esi for each loop
		add edi,30;						//Add 30 to esi for each loop
		loop L2;						//The second loop ends
		pop ecx;						//ecx minus 1 for each loop 
		loop L1;						//The first loop ends here

		//============================reslult=================================

		lea eax, result;
		push eax;
		call printf;					//Print "List of Student IDs, Student Names and their Grades: " on the screen
		add esp, 4;

		mov ecx, loopCounter;			//Save the value of loopCounter to ecx
		mov current_loop, 1;			//Set the value of current_loop to 1
		mov ID_address, -4;				//Set the value of ID_address to -4
		
		lea edi, student_name;			//Move the head address of student_name to edi

	output_result:						//Fuction: Out put the sorted list as results
		push ecx;						//Protect the value in ecx

		mov eax, current_loop;
		push eax; 
		lea eax, order;
		push eax;
		call printf;					//Print "current_loop." on the screen
		add esp, 8;

		add ID_address, 4;				//Add 4 to ID_address for each loop
		mov esi, ID_address;			//Save the value of ID_address in esi

		mov eax, student_ID[esi];		//Save the value of student_ID[esi] in eax
		push eax;
		lea eax, int_tab;
		push eax;
		call printf;					//Print "student_ID[esi]\t" on the screen
		add esp, 8;

		lea eax, [edi];					//Save the content of student_name in eax
		push eax;
		call printf;					//Print "student_name" on the screen
		add esp, 4;

		mov eax, grade[esi];			//Save the value of grade[esi] in eax
		push eax;
		lea eax, tab_int;				
		push eax;
		call printf;					//Print "\t grade[esi]" on the screen
		add esp, 8;

		lea eax, newline;
		push eax;
		call printf;					//Add a newline
		add esp, 4;

		inc current_loop;				//Add 1 to current_loop for each loop
		add edi, 30;					//Add 30 to edi for each loop

		pop ecx;						//ecx minus 1 for each loop 
		loop output_result;				//"output_result" Loop ends here

		//=====================================mean=============================

		mov ecx, loopCounter;			//Save the value of loopCounter to ecx
		lea esi, grade;					//Save the head address of grade in esi
		
	addLoop:							//Function: add all the grades together
		mov eax, [esi];					//Save the value of [esi] in eax
		add sum, eax;					//Add the value of eax to sum	
		add esi, 4;						//Add 4 to esi for each loop
		loop addLoop;					//"addLoop" ends here

		mov eax, dword ptr[sum];		//Save the value of sum in eax
		cdq;
		div dword ptr[loopCounter];		//Return the result of eax/loopCounter in eax
		mov average, eax;				//Save the value of eax in "average"

		mov eax, edx;					//Save the value of edx (remainder) in eax
		imul eax, 100;					//Return the result of eax*100 in eax
		cdq;
		div dword ptr[loopCounter];		//Return the result of eax/loopCounter in eax
		mov fraction_part, eax;			//Save the value of eax in "fraction_part"

		mov eax, edx;					//Save the value of edx (remainder) in eax
		imul eax, 2;					//Return the result of eax*2 in eax
		cmp eax, loopCounter;			//Compare the value of eax and loopCounter
		jge ceiling;					//If eax is greater than loopCounter, jump to "ceiling"
		cmp eax, loopCounter;			//Compare the value of eax and loopCounter
		jl floors;						//If eax is less than loopCounter, jump to "floors"

	ceiling:
		inc fraction_part				//Add one to the fraction_part

	floors:
		mov eax, average;
		push eax;
		lea eax, mean;
		push eax;
		call printf;					//Print out integer part of the mean on the screen
		add esp, 8;

		mov eax, fraction_part;
		push eax;
		lea eax, fraction1;
		push eax;
		call printf;					//Print out fraction part of the mean on the screen
		add esp, 8;


		//========================Standard deviation=================
		// Formula of Standard Deviation: s={[n(x1^2+x2^2+……+xn^2)-(x1+x2+……+xn)^2]/[n(n-1)]}^(1/2)
		// In the code:					  s={(loopCounter*square_sum-sum_square)/[loopCounter(loopCounter-1)]}^(1/2)

		mov ecx, loopCounter;			//Save the value of loopCounter to ecx
		lea esi, grade;					//Save the head address of grade in esi

	add_square:
		mov eax, [esi];					//Save the value of [esi] in eax
		mul eax;						//Save the value of [esi]*[esi] in eax
		add square_sum, eax;			//Add the value of [esi]*[esi] to square_sum
		add esi, 4;
		loop add_square;				//Loop to get the sum of the grades square

		mov eax, square_sum;			//Save the value of square_sum (square_sum=0 at first) in eax
		mul loopCounter;				//Save the value of square_sum*loopCounter in eax
		mov square_sum, eax;			//Get the result of n(x1^2+x2^2+……+xn^2) and it is saved in "square_sum"

		mov eax, sum_square;			//Save the value of sum_square (sum_square=1 at first) in eax
		mul sum;						//Save the value of sum in eax
		mul	sum;						//Save the value of sum*sum in eax
		mov sum_square, eax;			//Get the result of (x1+x2+……+xn)^2 and it is saved in "sum_square"

		mov eax, dividend;				//Save the value of dividend (dividend=0 at first) in eax
		add eax, square_sum;			//Add square_sum to eax
		sub eax, sum_square;			//eax minus sum_square
		mov dividend, eax;				//Get the result of [n(x1^2+x2^2+……+xn^2)-(x1+x2+……+xn)^2] and it is  saved in "dividend"

		fld divisor;					//Give a real number (divisor) to float stack, divisor=1 at first
		fimul loopCounter;				//Get the result of divisor*loopCounter
		fimul loopCounter;				//Get the result of divisor*loopCounter*loopCounter
		fst divisor;					//Save the result of loopCounter^2 back to divisor

		fild loopCounter;				//Give an integer number (loopCounter) to float stack
		fsubr divisor;					//Get the result of loopCounter^2-loopCounter
		fst divisor;					//Get the result of [n(n-1)]  and it is saved in "divisor"

		fld divisor;					//Give a real number (divisor) to float stack, divisor=loopCounter^2-loopCounter now
		fidivr dividend;				//Get the result of dividend/divisor
		fst deviation;					//dividend/divisor is [n(x1^2+x2^2+……+xn^2)-(x1+x2+……+xn)^2]/[n(n-1)] and it is saved in deviation

		fld deviation;					//Give a real number (deviation) to float stack, deviation=s^2 now
		fsqrt;							//To get the final answer s, we need to extract the square root of deviation
		fst deviation;					//Save the Standard Deviation in "deviation"

		sub esp, 8;						//Reserve stack for a double in stack

		fld dword ptr deviation;		//Load deviation
		fstp qword ptr[esp];			//Convert to double and store
		lea eax, deviation_format;
		push eax;
		call printf;					//Print "Standard deviation is %.4f" on the screen
		add esp, 12;


		//==============================fail=========================

		mov eax, fail;
		push eax;
		lea eax, fail_format;
		push eax;
		call printf;					//Print out how many students failed
		add esp, 8;

		//============================end============================
	finish:
		lea eax, end;
		push eax;
		call printf;					//Print "Program ends." on the screen
		add esp, 4;
		
	}

	system("Pause");
    return 0;
}

