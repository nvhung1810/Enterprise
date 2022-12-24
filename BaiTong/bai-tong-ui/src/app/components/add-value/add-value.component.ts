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
        hoten: '',
        tenbomon: '',
        hesoluong: 0,
    };
    submitted = false;

    constructor(private valueService: ValueService) {}

    saveTutorial(): void {
        const data = {
            hoten: this.value.hoten,
            tenbomon: this.value.tenbomon,
            hesoluong: this.value.hesoluong,
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
            hoten: '',
            tenbomon: '',
            hesoluong: 0,
        };
    }

    ngOnInit(): void {}
}
