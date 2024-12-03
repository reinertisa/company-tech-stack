import {FormProvider, useFieldArray, useForm} from "react-hook-form";
import FormSubmit from "../../Form/Submit";


export default function CompanyTechStackPage() {

    const formMethos = useForm({
        defaultValue: {
            name: '',
            techStacks: [],
        }
    });

    const onSubmit = async (val) => {
        console.log(val);
    }

    return (
       <FormProvider {...formMethods}>
           <form onSubmit={handleSubmit(onSubmit)}>
               <select>
                   <option>Amazon</option>
                   <option>Linkedin</option>
                   <option>Google</option>
                   <option>Meta</option>
               </select>
               <FormSubmit>Save</FormSubmit>
           </form>
       </FormProvider>
    )
}


// function TechStackArray(
// const {fields, append, remove} = useFieldArray({
//     name: 'techStacks', control
// });

//     return (
//         <div>
//             <label htmlFor="techStacks">Tech Name: </label>
//             {map(fields, (field, index) => {
//                 return (
//                     <div key={field.id}>
//                         <input type="text" {...register(`techStacks.${index}.name`)} />
//                         <input type="text" {...register(`techStacks.${index}.category`)} />
//                         {index > 0 && (
//                             <button type="button" onClick={() => remove({name: ''})}>
//                                 Remove
//                             </button>
//                         )
//                         }
//                     </div>
//                 )
//
//             })}
//             <button type="button" onClick={() => append({name: ''})}>Add tech stack</button>
//         </div>
//     );
// )