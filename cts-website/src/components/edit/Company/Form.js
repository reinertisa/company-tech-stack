import {useForm, FormProvider} from 'react-hook-form';
import axios from 'axios';
import FormText from "../../form/FormText";
import FormSubmit from "../../form/Submit";

export default function CompanyForm({onSave}) {
    const formMethods = useForm({
        defaultValues: {
            name: '',
            country: '',
            size: '',
            industry: '',
            type: '',
        }
    });

    const {handleSubmit, control} = formMethods;

    const onSubmit = async (data) => {
        const rez = await axios.post("http://localhost:8080/api/v1/companies", {
            ...data,
        })
        onSave(rez?.data);
    }

    return (
        <FormProvider {...formMethods}>
        <form onSubmit={handleSubmit(onSubmit)}>
            <FormText name="name" label="Company name" />
            <FormText name="country" label="Country" />
            <FormText name="size" label="Number of employees" />
            <FormText name="industry" label="Industry" />
            <FormText name="type" label="Type" />
            <FormSubmit>Save</FormSubmit>
        </form>
        </FormProvider>
    )
}