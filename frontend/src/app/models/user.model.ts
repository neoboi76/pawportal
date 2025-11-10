/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Model class for users

export type UserModel = {
    email: string;
    firstName: string;
    lastName: string;
    id: number;
    mobileNumber?: string;
    gender: string;
    country: string;
    language: string;
}