import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ValueService } from 'src/app/services/value.service';
import { Value } from 'src/app/models/value.model';

@Component({
    selector: 'app-value-details',
    templateUrl: './value-details.component.html',
    styleUrls: ['./value-details.component.scss'],
})
export class ValueDetailsComponent implements OnInit {
    @Input() viewMode = false;
    thanhtien: number = 0;

    @Input() currentValue: Value = {
        tengieng: '',
        vitrix: 0,
        vitriy: 0,
        dosau: 0,
        diadanh: '',
    };

    message = '';

    constructor(
        private valueService: ValueService,
        private route: ActivatedRoute,
        private router: Router,
    ) {}

    ngOnInit(): void {
        if (!this.viewMode) {
            this.message = '';
            this.getValue(this.route.snapshot.params['id']);
        }
    }

    getValue(id: string): void {
        this.valueService.get(id).subscribe({
            next: (data) => {
                this.currentValue = data;
            },
            error: (e) => console.error(e),
        });
    }

    updatePublished(status: boolean): void {
        const data = {
            // sủa cái này theo table
            tengieng: this.currentValue.tengieng,
            vitrix: this.currentValue.vitrix,
            vitriy: this.currentValue.vitriy,
            dosau: this.currentValue.dosau,
            diadanh: this.currentValue.diadanh,

            // published: status,
        };

        this.message = '';

        // this.valueService.update(this.currentValue.id, data).subscribe({
        //     next: (res) => {
        //         console.log(res);
        //         this.currentValue.published = status;
        //         this.message = res.message
        //             ? res.message
        //             : 'The status was updated successfully!';
        //     },
        //     error: (e) => console.error(e),
        // });
    }

    updateValue(): void {
        this.message = '';

        this.valueService
            .update(this.currentValue.id, this.currentValue)
            .subscribe({
                next: (res) => {
                    console.log(res);
                    this.message = res.message
                        ? res.message
                        : 'This Value was updated successfully!';
                },
                error: (e) => console.error(e),
            });
    }

    deleteValue(): void {
        this.valueService.delete(this.currentValue.id).subscribe({
            next: (res) => {
                console.log(res);
                this.router.navigate(['/values']);
            },
            error: (e) => console.error(e),
        });
    }
}
