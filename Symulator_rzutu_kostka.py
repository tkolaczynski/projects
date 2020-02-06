#Symulator rzutu kostka
#@TomaszKolaczynski
import random

def kostka(number):
    if number == 1:
        print("""
-------
|     |
|  o  |
|     |
-------
""")
    elif number == 2:
        print("""
-------
| o   |
|     |
|   o |
-------
""")
    elif number == 3:
        print("""
-------
| o   |
|  o  |
|   o |
-------
""")
    elif number == 4:
        print("""
-------
| o o |
|     |
| o o |
-------
""")
    elif number == 5:
        print("""
-------
| o o |
|  o  |
| o o |
-------
""")
    elif number == 6:
        print("""
-------
| o o |
| o o |
| o o |
-------
""")
    else:
        print("ERROR")

menu = None

print("Witaj w grze RZUT KOSTKA")
while menu!="0":
    print(""""
0 - Wyjscie
1 - Rzut koscia    
""")
    menu = input("Wybierz co chcesz zrobic: ")
    if menu=="0":
        print("Koniec gry")
    elif menu == "1":
        rzut_koscia = random.randrange(1,7)
        kostka(rzut_koscia)
        if rzut_koscia==1:
            print("Wypadlo Ci",rzut_koscia,"oczko")
        elif rzut_koscia<5:
            print("Wypadly Ci",rzut_koscia,"oczka")
        else:
            print("Wypadlo Ci",rzut_koscia,"oczek")

        print()

input("Nacisnij aby klawisz aby zakonczyc")