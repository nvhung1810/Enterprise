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
        tenhang: '',
        gia_hung: 0,
        soluong: 0,
        ngaynhap: '',
        loaihang: '',
    };
    submitted = false;

    constructor(private valueService: ValueService) {}

    saveTutorial(): void {
        const data = {
            tenhang: this.value.tenhang,
            gia_hung: this.value.gia_hung,
            soluong: this.value.soluong,
            ngaynhap: this.value.ngaynhap,
            loaihang: this.value.loaihang,
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
            tenhang: '',
            gia_hung: 0,
            soluong: 0,
            ngaynhap: '',
            loaihang: '',
        };
    }

    ngOnInit(): void {}
}
