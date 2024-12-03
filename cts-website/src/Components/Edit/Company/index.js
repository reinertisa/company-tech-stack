import CompanyForm from "./Form";
import CompanyList from "./List";
import ReadableWithTemplate from "../../Templates/ReadableWith";
import {useEffect, useState} from "react";
import axios from "axios";
import useGet from "../../Hooks/getData";

export default function CompanyPage() {
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState(null);
    const [error, setError] = useState('');

    const {response: typeResponse, error: typeError} = useGet('http://localhost:8080/api/v1/companies/types');

    useEffect(() => {
        let mount = true;
        const loadData = async () => {
            try {
                setLoading(true);
                const rez = await axios.get('http://localhost:8080/api/v1/companies');
                if (mount) {
                    setData(rez?.data);
                }
                setLoading(false);
            } catch (err) {
                setError(err);
            }
        }
        // noinspection JSIgnoredPromiseFromCall
        loadData();

        return () => {
            mount = false;
        }

    }, []);

    const saveHandler = (val) => {
        setData([...data, val]);
    }

    let body = loading ? 'Loading' : '';
    if (data && typeResponse) {
        body = (
            <>
                <CompanyForm types={typeResponse?.data} onSave={saveHandler}  />
                <CompanyList data={data} />
            </>

        );
    } else if (error) {
        body = error;
    }

    return (
        <ReadableWithTemplate>
            {body}
        </ReadableWithTemplate>
    );
}