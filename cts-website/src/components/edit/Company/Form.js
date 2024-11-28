import {useForm} from 'react-hook-form';
import axios from 'axios';

export default function CompanyForm() {
    const {register, handleSubmit} = useForm({
        defaultValues: {
            name: '',
        }
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
                <input
                    id="name"
                    type="text"
                    {...register('name', {
                        required: {
                            value: true,
                            message: 'This field is required.'
                        }
                    })}
                />
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
                <button type="submit">Submit</button>
            </div>
        </form>
    )
}