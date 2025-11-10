/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Model class for dogs

export interface Dog {
  dogId: number;
  name: string;
  description: string;
  breed: string;
  age: number;
  size: 'SMALL' | 'MEDIUM' | 'LARGE' | 'EXTRA_LARGE';
  gender: string;
  imageUrl: string;
  temperament: string;
  vaccinated: boolean;
  spayedNeutered: boolean;
  status: 'AVAILABLE' | 'PENDING' | 'ADOPTED';
  createdAt: string;
  updatedAt: string;
}