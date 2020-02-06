#Program sprawdza czy podane przez uzytkownika slowo jest palindromem
#Autor Tomasz Kolaczynski
menu = None

while menu!="0":
    print("""
0 - Zakoncz
1 - Wpisz slowo
    """)
    menu = input("Co chcesz zrobic? ")
    if menu=="0":
        print("Zakoncz")
    elif menu=="1":
        word = input("Wpisz slowo: ")
        reverse_word = word[::-1]
        if word == reverse_word:
            print("Slowo",word,"jest palindromem")
        else:
            print("Slowo",word,"nie jest palindromem")
    else:
        print("Blad")
        
input("Nacisnij by zakonczyc")