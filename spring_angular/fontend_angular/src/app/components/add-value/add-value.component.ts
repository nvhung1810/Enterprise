import { Component, OnInit } from '@angular/core';
import { Value } from 'src/app/models/value.model';
import { ValueService } from 'src/app/services/value.service';

@Component({
    selector: 'app-add-value',
    templateUrl: './add-value.component.html',
    styleUrls: ['./add-value.component.scss'],
})
export class AddValueComponent implements OnInit {
    value: Value = {
        tengieng: '',
        vitrix: 0,
        vitriy: 0,
        dosau: 0,
        diadanh: '',
    };
    submitted = false;

    constructor(private valueService: ValueService) {}

    saveTutorial(): void {
        const data = {
            tengieng: this.value.tengieng,
            vitrix: this.value.vitrix,
            vitriy: this.value.vitriy,
            dosau: this.value.dosau,
            diadanh: this.value.diadanh,
        };

        this.valueService.create(data).subscribe({
            next: (res) => {
                console.log(res);
                this.submitted = true;
            },
            error: (e) => console.error(e),
        });
    }

    newTutorial(): void {
        this.submitted = false;
        this.value = {
            tengieng: '',
            vitrix: 0,
            vitriy: 0,
            dosau: 0,
            diadanh: '',
        };
    }

    ngOnInit(): void {}
}
