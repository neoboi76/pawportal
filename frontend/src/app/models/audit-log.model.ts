/* Developed by Group 6:
    Kenji Mark Alan Arceo
    Carl Norbi Felonia
    Ryonan Owen Ferrer
    Dino Alfred Timbol
    Mike Emil Vocal */ 

//Model class for audit logs


export interface AuditLog {
    auditId: number;
    user?: {
        userId: number;
        email: string;
        firstName: string;
        lastName: string;
    };
    action: string;
    ipAddress: string;
    userAgent?: string;
    details?: string;
    timestamp: string;
    success: boolean;
    errorMessage?: string;
}