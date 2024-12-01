import {useForm, useFieldArray} from 'react-hook-form';
import {map} from 'lodash';
import axios from 'axios';

export default function CompanyForm() {
    const {register, handleSubmit, control} = useForm({
        defaultValues: {
            name: 'Linkedin',
            companyId: 'L1234',
            address: 'Sunnyvale, CA',
            numOfEmployees: 100,
            industry: 'Social',
            type: 'MULTINATIONAL',
            techStacks: [{
                name: '',
                category: ''
            }]
        }
    });

    const {fields, append, remove} = useFieldArray({
        name: 'techStacks', control
    });

    const onSubmit = async (data) => {
        const result = await axios.post("http://localhost:8080/api/v1/companies", {
            ...data,
        })
        console.log('Data submitted successfully');
        console.log(result);
    }

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <div>
                <label htmlFor="name">Company name: </label>
                <input id="name" type="text"{...register('name')}/>
            </div>

            <div>
                <label htmlFor="companyId">Company ID: </label>
                <input id="companyId" type="text" {...register('companyId')}/>
            </div>

            <div>
                <label htmlFor="address">Address: </label>
                <input id="address" type="text" {...register("address")} />
            </div>

            <div>
                <label htmlFor="numOfEmployees">Number of employees: </label>
                <input id="numOfEmployeess" type="text" {...register("numOfEmployees")} />
            </div>

            <div>
                <label htmlFor="industry">Industry: </label>
                <input id="industry" type="text" {...register("industry")} />
            </div>

            <div>
                <label htmlFor="type">Company Type: </label>
                <input id="type" type="text" {...register("type")} />
            </div>

            <div>
                <label htmlFor="techStacks">Tech Name: </label>
                {map(fields, (field, index) => {
                    return (
                        <div key={field.id}>
                            <input type="text" {...register(`techStacks.${index}.name`)} />
                            <input type="text" {...register(`techStacks.${index}.category`)} />
                            {index > 0 && (
                                    <button type="button" onClick={() => remove({name: ''})}>
                                        Remove
                                    </button>
                                )
                            }
                        </div>
                    )

                })}
                <button type="button" onClick={() => append({name: ''})}>Add tech stack</button>
            </div>

            <div>
                <button type="submit">Submit</button>
            </div>
        </form>
    )
}