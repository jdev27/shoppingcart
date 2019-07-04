import { NgModule } from "@angular/core";
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/'
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
    imports: [MatButtonModule, MatDialogModule,
        MatFormFieldModule, MatCheckboxModule,
        MatInputModule, MatDatepickerModule,
        MatNativeDateModule,
        MatSnackBarModule, MatPaginatorModule,
        MatTableModule, MatToolbarModule,
        MatIconModule],
    exports: [MatButtonModule, MatDialogModule,
        MatFormFieldModule, MatCheckboxModule,
        MatInputModule, MatDatepickerModule,
        MatSnackBarModule, MatPaginatorModule,
        MatTableModule, MatToolbarModule,
        MatIconModule],
})
export class AppMaterialModule { }