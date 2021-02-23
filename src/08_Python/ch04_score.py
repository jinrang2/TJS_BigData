import sys


if(len(sys.argv) >= 2):
    score = int(sys.argv[1])
else:
    score = int (input('Enter your 점수? '))
    
if 90<= score <= 100:
    grade = 'A'
elif 80<= score <= 90:
    grade = 'B'
elif 70<= score <= 80:
    grade = 'C'
elif 60<= score <= 70:
    grade = 'D'
elif 0<= score <= 60:
    grade = 'F'
else:
    grade = '유효하지 않은 점수'


print('입력한 점수는 {}이고 {}등급'.format(score,grade))
    