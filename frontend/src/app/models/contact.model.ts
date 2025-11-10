/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Model class for contact forms


export interface ContactForm {
  contactId?: number;
  name: string;
  email: string;
  phone: string;
  subject: string;
  message: string;
  submittedAt?: string;
}