import {useForm, FormProvider} from 'react-hook-form';
import axios from 'axios';
import {map} from 'lodash';
import FormSubmit from "../../Form/Submit";
import FormText from "../../Form/Text";

export default function CompanyForm({types, onSave}) {
    const formMethods = useForm({
        defaultValues: {
            name: '',
            country: '',
            size: '',
            industry: '',
            type: '',
        }
    });

    const {register, handleSubmit} = formMethods;

    const onSubmit = async (data) => {
        const rez = await axios.post("http://localhost:8080/api/v1/companies", {
            ...data,
        })
        onSave(rez?.data);
    }

    return (
        <FormProvider {...formMethods}>
            <form onSubmit={handleSubmit(onSubmit)}>
                <FormText name="name" label="Company name"/>
                <FormText name="country" label="Country"/>
                <FormText name="size" label="Number of employees"/>
                <FormText name="industry" label="Industry"/>

                <label htmlFor="type">Company type</label>
                <select {...register('type')}>
                    {map(types, (type) => {
                        return (
                            <option value={type}>
                                {type}
                            </option>
                        );
                    })}
                </select>
                <FormSubmit>Save</FormSubmit>
            </form>
        </FormProvider>
    )
}