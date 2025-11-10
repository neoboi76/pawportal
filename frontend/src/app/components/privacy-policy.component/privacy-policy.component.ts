import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 
    
@Component({
    selector: 'app-privacy-policy',
    standalone: true,
    imports: [CommonModule],
    templateUrl: './privacy-policy.component.html',
    styleUrl: './privacy-policy.component.css'
})
export class PrivacyPolicyComponent implements OnInit {
    lastUpdated = 'November 5, 2025';

    ngOnInit(): void {
        window.scrollTo(0, 0);
    }
}