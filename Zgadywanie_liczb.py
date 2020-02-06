#Gra w zgadywanie licz
#Autor Tomasz Kolaczynski
#Komputer losuje liczbe z przedzialu od 1 do 100, uzytkownik proboje ja odgadnac
import random

number = random.randint(1,100)
user_choice = None
chance = 0
while user_choice!=number:
    user_choice = int(input("Zgadnij liczbe o ktorej mysle: "))
    chance+=1
    if user_choice>number:
        print("Za duzo!")
        
    elif user_choice<number:
        print("Za malo")


print("GRATULACJE! Liczba",number,"zostala odgadnieta za",chance,"razem!")
input("press")